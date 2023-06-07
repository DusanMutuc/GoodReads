package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.KorisnikDto;
import WebProjekat.GoodReads.dto.LoginDto;
import WebProjekat.GoodReads.dto.RegisterDto;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.repository.KorisnikRepository;
import WebProjekat.GoodReads.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KorisnikKontroler {
    @Autowired
    private KorisnikService korisnikService;

    //TODO dodati uslov da ne sme login ako si vec prijavljen
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto, HttpSession session){
        Korisnik korisnik = korisnikService.login(dto.getEmail(),dto.getLozinka());
        if(korisnik == null){
            return new ResponseEntity<String>("Podaci se ne poklapaju sa nalogom u sistemu", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("korisnik",korisnik);
        return new ResponseEntity<String>("Uspesno prijavljeni",HttpStatus.OK);
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
            //TODO dodati 3 primarne police kad koncept police bude postojao :)
            korisnikService.save(korisnik1);
            return new ResponseEntity<String>("Uspesno ste registrovani", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Lozinke se ne poklapaju",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/api/korisnici/{id}")
    public ResponseEntity<KorisnikDto> findById(@PathVariable Long id){
        Korisnik korisnik = korisnikService.findById(id);
        if(korisnik == null ) return new ResponseEntity<KorisnikDto>(new KorisnikDto(),HttpStatus.BAD_REQUEST);
        KorisnikDto dto = new KorisnikDto(korisnik);
        return new ResponseEntity<KorisnikDto>(dto,HttpStatus.OK);
    }
}
