package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.KorisnikDto;
import WebProjekat.GoodReads.dto.ZanrDto;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Uloga;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.service.ZanrService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/api/zanrovi")
public class ZanrKontroler {
    @Autowired
    private ZanrService zanrService;

    //Ne treba da se brisu zanrovi
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<String>("Nisi prijavljen", HttpStatus.UNAUTHORIZED);
        }

        if (!korisnik.getUloga().equals(Uloga.ADMINISTRATOR)) {
            return new ResponseEntity<String>("Nisi prijavljen kao administrator", HttpStatus.FORBIDDEN);
        }

        zanrService.delete(id);
        return ResponseEntity.ok("Obrisano");
    }
    */
    @GetMapping("/{id}")
    public ResponseEntity<ZanrDto> findById(@PathVariable Long id) {
        Zanr zanr = zanrService.findById(id);
        if(zanr == null ) return new ResponseEntity<ZanrDto>(new ZanrDto(),HttpStatus.BAD_REQUEST);
        ZanrDto dto = new ZanrDto(zanr);
        return new ResponseEntity<ZanrDto>(dto,HttpStatus.OK);
    }

    @PostMapping("/dodaj")
    public ResponseEntity<String> dodajZanr(@RequestParam String naziv,HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("Niste ulogovani!",HttpStatus.BAD_REQUEST);
        }
        if(!korisnik.getUloga().equals(Uloga.ADMINISTRATOR)){
            return new ResponseEntity<String>("Niste admin!",HttpStatus.FORBIDDEN);
        }
        if(zanrService.exists(naziv)){
            return new ResponseEntity<String>("zanr vec postoji",HttpStatus.BAD_REQUEST);
        }

        zanrService.save(naziv);
        return new ResponseEntity<String>(naziv,HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Zanr>> findAll(){
        return new ResponseEntity<List<Zanr>>(zanrService.findAll(),HttpStatus.OK);
    }
}
