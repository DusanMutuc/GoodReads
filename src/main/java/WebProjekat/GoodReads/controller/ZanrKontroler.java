package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Uloga;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.service.ZanrService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zanrovi")
public class ZanrKontroler {
    @Autowired
    private ZanrService zanrService;

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

    @GetMapping("/{id}")
    public ResponseEntity<Zanr> findById(@PathVariable Long id) {
        return ResponseEntity.ok(zanrService.findById(id));
    }

    @PostMapping("/{naziv}")
    public ResponseEntity<String> add(@PathVariable String naziv) {
        if(zanrService.exists(naziv)){
            return new ResponseEntity<String>("zanr vec postoji",HttpStatus.BAD_REQUEST);
        }

        zanrService.save(naziv);
        return new ResponseEntity<String>(naziv,HttpStatus.OK);
    }
}