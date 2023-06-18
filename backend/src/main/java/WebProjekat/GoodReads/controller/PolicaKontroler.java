package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Polica;
import WebProjekat.GoodReads.service.KorisnikService;
import WebProjekat.GoodReads.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
public class PolicaKontroler {
    @Autowired
    private PolicaService policaService;

    @Autowired
    private KorisnikService korisnikService;

    @DeleteMapping("/api/deletePolice")
    public ResponseEntity<String>  delete(@RequestParam String imePolice, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("niste ulogovani",HttpStatus.BAD_REQUEST);
        }
        Korisnik korisnik1 = korisnikService.findById(korisnik.getID());
        Set<Polica> police = korisnik1.getPolice();

        Polica polica = policaService.findByNazivInKorisnik(police,imePolice);
        if(polica == null){
            return new ResponseEntity<String>("nemate policu sa tim imenom", HttpStatus.BAD_REQUEST);
        }
        Long id = polica.getID();
        if(polica.getPrimarna()){
            return new ResponseEntity<String>("Ne mozete brisati primarnu policu", HttpStatus.FORBIDDEN);
        }
        police.remove(polica);
        korisnikService.save(korisnik1);
        policaService.deleteById(polica.getID());
        return new ResponseEntity<String>("uspesno brisanje police",HttpStatus.OK);
    }
}
