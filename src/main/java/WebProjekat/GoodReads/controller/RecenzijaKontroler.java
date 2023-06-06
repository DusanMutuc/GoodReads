package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.RecenzijaDto;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Recenzija;
import WebProjekat.GoodReads.service.RecenzijaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/recenzije")
public class RecenzijaKontroler {
    @Autowired
    private RecenzijaService recenzijaService;

    @PostMapping("/post")
    public ResponseEntity<String> add(@RequestBody RecenzijaDto dto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null) return new ResponseEntity<String>("Niste ulogovani",HttpStatus.BAD_REQUEST);
        recenzijaService.save(dto.getTekst(),dto.getOcena(),korisnik);
        return new ResponseEntity<String>("uspesno", HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute( "korisnik");
        if(korisnik == null){
            return new ResponseEntity<String>("Niste prijavljeni",HttpStatus.BAD_REQUEST);
        }
        if(recenzijaService.findByID(id) == null){
            return new ResponseEntity<String>("Recenzija ne postoji", HttpStatus.BAD_REQUEST);
        }
        if(recenzijaService.findByID(id).getKorisnik().getID().equals(korisnik.getID())){
            recenzijaService.delete(id);
            return new ResponseEntity<String>("Uspesno brisanje recenzije", HttpStatus.OK);
        }
        return new ResponseEntity<String>(korisnik.getIme(),HttpStatus.OK);
        // return new ResponseEntity<String>("Vi niste napisali recenziju",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recenzija> read(Long id){
        return new ResponseEntity<Recenzija>(recenzijaService.findByID(id), HttpStatus.OK);
    }

// ? korisnik  ? knjiga

}
