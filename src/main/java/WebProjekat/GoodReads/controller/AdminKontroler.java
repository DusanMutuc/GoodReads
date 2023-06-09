package WebProjekat.GoodReads.controller;


import WebProjekat.GoodReads.dto.KorisnikDto;
import WebProjekat.GoodReads.dto.ZahtevZaAktivacijuNalogaDto;
import WebProjekat.GoodReads.entity.*;
import WebProjekat.GoodReads.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/admin")
public class AdminKontroler {
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private KnjigaService knjigaService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private ZahtevZaAktivacijuNalogaService zahtevZaAktivacijuNalogaService;
    @Autowired
    private PolicaService policaService;


    @PostMapping("/autori/dodaj")
    public ResponseEntity<String> dodajAutora(HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("Niste ulogovani!",HttpStatus.BAD_REQUEST);
        }
        if(!korisnik.getUloga().equals(Uloga.ADMINISTRATOR)){
            return new ResponseEntity<String>("Niste admin!",HttpStatus.FORBIDDEN);
        }
        Autor autor = new Autor();
        autor.setAktivan(false);
        autor.setUloga(Uloga.AUTOR);
        autorService.save(autor);
        return new ResponseEntity<String>("uspesno dodat autor",HttpStatus.OK);
    }
    @PostMapping("/autori/azuriraj")
    public ResponseEntity<String> azurirajAutora(@RequestBody KorisnikDto dto,@RequestParam Long autorId, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if (korisnik == null) {
            return new ResponseEntity<String>("Niste ulogovani!", HttpStatus.BAD_REQUEST);
        }
        if (!korisnik.getUloga().equals(Uloga.ADMINISTRATOR)) {
            return new ResponseEntity<String>("Niste admin!", HttpStatus.FORBIDDEN);
        }
        if(autorService.findById(autorId) == null){
            return new ResponseEntity<String>("ne postoji autor sa tim Id-jem", HttpStatus.BAD_REQUEST);
        }
        Autor autor = autorService.findById(autorId);
        if(autor.isAktivan()){
            return new ResponseEntity<String>("Ne moze se azurirati aktivan autor", HttpStatus.BAD_REQUEST);
        }
        autorService.azuriraj(dto,autorId);
        return new ResponseEntity<String>("uspesno azuriranje",HttpStatus.OK);
    }


    //trenutno saljemo dto kroz postman, ali ti podaci ce se nalaziti u zahtevu kada admin klikne na njega
    @PostMapping("autori/zahtev")
    public ResponseEntity<String> zahtev(@RequestParam Boolean prihvacen, @RequestBody ZahtevZaAktivacijuNalogaDto zahtev, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("Niste ulogovani!",HttpStatus.BAD_REQUEST);
        }
        if(!korisnik.getUloga().equals(Uloga.ADMINISTRATOR)){
            return new ResponseEntity<String>("Niste admin!",HttpStatus.FORBIDDEN);
        }
        if(autorService.findById(zahtev.getIdAutor()) == null){
            return new ResponseEntity<String>("Ne postoji autor sa tim Id-jem ", HttpStatus.BAD_REQUEST);
        }
        if(autorService.findById(zahtev.getIdAutor()).isAktivan()){
            return new ResponseEntity<String>("Autor je vec aktivan!", HttpStatus.BAD_REQUEST);
        }
        if(prihvacen){
            Autor autor = autorService.findById(zahtev.getIdAutor());
            autor.setAktivan(true);
            Set<Polica> police = policaService.savePrimary();
            autor.setPolice(police);
            autorService.save(autor);

            //TODO poslati mail na mail adresu
            return new ResponseEntity<String>("Odobren zahtev!",HttpStatus.OK);
        }
        else{
            //TODO poslati mail na mail adresu
            return new ResponseEntity<String>("Nije prihvacen zahtev",HttpStatus.OK);
        }
    }
}
