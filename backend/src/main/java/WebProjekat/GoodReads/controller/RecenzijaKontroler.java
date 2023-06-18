package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.RecenzijaDto;
import WebProjekat.GoodReads.dto.ZanrDto;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Recenzija;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.service.RecenzijaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(value = "/api/recenzije")
public class RecenzijaKontroler {
    @Autowired
    private RecenzijaService recenzijaService;


    //recenzije ce se dodavati kada korisnik pomeri na Read policu, pa cemo proslediti o kojoj knjizi je rec, sada samo dodajemo
    @PostMapping("/post")
    public ResponseEntity<String> dodajRecenziju(@RequestBody RecenzijaDto dto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik == null) return new ResponseEntity<String>("Niste ulogovani",HttpStatus.BAD_REQUEST);
        recenzijaService.save(dto.getTekst(),dto.getOcena(),korisnik);
        return new ResponseEntity<String>("uspesno", HttpStatus.OK);
    }
    /*  @DeleteMapping("delete/{id}")
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
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecenzijaDto> findById(@PathVariable Long id){

        Recenzija recenzija = recenzijaService.findById(id);
        if(recenzija == null ) return new ResponseEntity<RecenzijaDto>(new RecenzijaDto(),HttpStatus.BAD_REQUEST);
        RecenzijaDto dto = new RecenzijaDto(recenzija);
        return new ResponseEntity<RecenzijaDto>(dto,HttpStatus.OK);
    }
    //TODO za svaku knjigu moguce je videti njene recenzije

// ? korisnik  ? knjiga

}
