package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.*;
import WebProjekat.GoodReads.entity.Knjiga;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Polica;
import WebProjekat.GoodReads.entity.Uloga;
import WebProjekat.GoodReads.repository.KorisnikRepository;
import WebProjekat.GoodReads.service.KnjigaService;
import WebProjekat.GoodReads.service.KorisnikService;
import WebProjekat.GoodReads.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
public class KorisnikKontroler {
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private PolicaService policaService;
    @Autowired
    private KnjigaService knjigaService;

    //TODO dodati uslov da ne sme login ako si vec prijavljen
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik != null){
            return new ResponseEntity<String>("Vec ste ulogovani!", HttpStatus.BAD_REQUEST);
        }
        korisnik = korisnikService.login(dto.getEmail(),dto.getLozinka());
        if(korisnik == null){
            return new ResponseEntity<String>("Podaci se ne poklapaju sa nalogom u sistemu", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("korisnik",korisnik);
        return new ResponseEntity<String>("Uspesno prijavljeni",HttpStatus.OK);
    }

    @PostMapping("api/logout")
    public ResponseEntity<String> logout(HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("Niste ulogovani, ne mozete se izlogovati", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("korisnik",null);
        return new ResponseEntity<String>("izlogovani ste!",HttpStatus.OK);
    }
    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto dto,HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik!=null) return new ResponseEntity<String>("Vec ste prijavljeni",HttpStatus.BAD_REQUEST);
        if(korisnikService.findByKorisnickoIme(dto.getKorisnickoIme()) != null){
            return new ResponseEntity<String>("Postoji nalog sa tim korisnickim imenom",HttpStatus.BAD_REQUEST);
        }
        if(korisnikService.findByEmail(dto.getMail()) != null){
            return new ResponseEntity<String>("Postoji nalog sa tim emailom",HttpStatus.BAD_REQUEST);
        }
        if(dto.getLozinka().equals(dto.getLozinkaConfirmation())) {
            Korisnik korisnik1 = new Korisnik(dto);
            Set<Polica> police = new HashSet<>();
            police = policaService.savePrimary();
            korisnik1.setPolice(police);
            korisnikService.save(korisnik1);
            return new ResponseEntity<String>("Uspesno ste registrovani", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Lozinke se ne poklapaju",HttpStatus.BAD_REQUEST);
    }

    //TODO fali brisanje knjiga

    @GetMapping("/api/korisnici/{id}")
    public ResponseEntity<KorisnikDto> findById(@PathVariable Long id){
        Korisnik korisnik = korisnikService.findById(id);
        if(korisnik == null ) return new ResponseEntity<KorisnikDto>(new KorisnikDto(),HttpStatus.BAD_REQUEST);
        KorisnikDto dto = new KorisnikDto(korisnik);
        return new ResponseEntity<KorisnikDto>(dto,HttpStatus.OK);
    }
    @PostMapping("/api/korisnik/addPolica")
    public ResponseEntity<String>addPolica(@RequestParam String naziv, HttpSession session){
        Korisnik korisnik =(Korisnik) session.getAttribute("korisnik");
        Polica polica = new Polica(naziv);
        Korisnik korisnik1 = korisnikService.findById(korisnik.getID());
        if(korisnik1 == null){
            return new ResponseEntity<String>("Niste ulogovani",HttpStatus.BAD_REQUEST);
        }
        if(policaService.containsPolicaByName(korisnik1.getPolice(),naziv)){
            return new ResponseEntity<String>("Vec imate policu sa tim nazivom", HttpStatus.BAD_REQUEST);
        }
        korisnik1 = korisnikService.addPolica(polica,korisnik1);
        korisnik1 = korisnikService.save(korisnik1);
        return new ResponseEntity<String>("Uspesno dodavanje police!", HttpStatus.OK);
    }
    @PostMapping("api/korisnik/police/addKnjiga/")
    public ResponseEntity<String>addKnjiga(@RequestParam Long knjigaId, @RequestParam String policaName, HttpSession session ){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("Niste prijavljeni",HttpStatus.BAD_REQUEST);
        }
        if(knjigaService.findById(knjigaId) == null){
            return new ResponseEntity<String>("Knjiga ne postoji!",HttpStatus.BAD_REQUEST);
        }
        if(policaService.findByNazivInKorisnik(korisnik.getPolice(),policaName)== null){
            return new ResponseEntity<String>("Ne postoji ta polica", HttpStatus.BAD_REQUEST);
        }
        if(!korisnikService.primaryPoliceContainBook(korisnik,knjigaId) && !policaName.equals("Read") && !policaName.equals("Currently Reading")&& !policaName.equals("Want To Read")){

            return new ResponseEntity<String>("Knjiga mora biti na jednoj od primarnih polica", HttpStatus.BAD_REQUEST);
        }
        korisnikService.addBookToShelf(korisnik,policaName,knjigaId);
        korisnikService.save(korisnik);
        return new ResponseEntity<String>("Sacuvana knjiga na polici!",HttpStatus.OK);
    }


    //TODO kad dodje 3. kontrolna tacka, bice dugme za azuriranje svakog polja ponaosob, pa cemo tad azurirati email i pass, za sada ne zbog sigurnosnih razloga
    @PostMapping("api/korisnik/update")
    public ResponseEntity<String>updateProfile(@RequestParam(required = false)String ime, @RequestParam(required = false)String prezime, @RequestParam(required = false)Date datum,@RequestParam(required = false)String slika,@RequestParam(required = false)String opis,HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik== null){
            return new ResponseEntity<String>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }
        if(ime != null){
            korisnik.setIme(ime);
        }
        if(prezime != null){
            korisnik.setPrezime(prezime);
        }
        if(datum != null){
            korisnik.setDatumRodjenja(datum);
        }
        if(slika != null){
            korisnik.setProfilnaSlika(slika);
        }
        if(opis != null){
            korisnik.setOpis(opis);
        }

        korisnikService.save(korisnik);

        return new ResponseEntity<String>("Uspesno Azuriranje!",HttpStatus.OK);
    }

    @GetMapping("/api/izlistajKorisnikovePolice")
    public ResponseEntity<Set<Polica>> listAllPolice(HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            Set<Polica> police = new HashSet<>();
            return new ResponseEntity<Set<Polica>>(police,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Set<Polica>>(korisnik.getPolice(),HttpStatus.OK);
    }
    @PostMapping("/api/azurirajKnjigu")
    public ResponseEntity<String> azurirajKnjigu(@RequestParam Integer brojStrana, @RequestParam(required = false) String naslov, @RequestParam(required = false) String opis, @RequestParam(required = false) String naslovnaFotografija,@RequestParam Long knjigaId,HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("Niste ulogovani!",HttpStatus.BAD_REQUEST);
        }
        if(korisnik.getUloga().equals(Uloga.CITALAC)){
            return new ResponseEntity<String>("Citalac ne moze da azurira knjige",HttpStatus.FORBIDDEN);
        }
        if(knjigaService.findById(knjigaId) == null){
            return new ResponseEntity<String>("ne postoji knjiga sa tim Id-jem", HttpStatus.BAD_REQUEST);
        }
        Knjiga knjiga = knjigaService.findById(knjigaId);
        knjiga =  knjigaService.azuriraj(brojStrana,naslov,opis,naslovnaFotografija,knjigaId);
        knjigaService.save(knjiga);
        korisnikService.save(korisnik);
        return new ResponseEntity<String>("izvrseno azuriranje!", HttpStatus.OK);

    }

    //TODO dodavanje recenzije kada korisnik stavi knjigu na READ policu, za sada samo moguce dodavanje recenzija bez uslova u recenzijaKontroler





}
