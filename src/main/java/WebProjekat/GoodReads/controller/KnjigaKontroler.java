package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.KnjigaDto;
import WebProjekat.GoodReads.entity.Knjiga;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Uloga;
import WebProjekat.GoodReads.repository.KnjigaRepository;
import WebProjekat.GoodReads.service.KnjigaService;
import WebProjekat.GoodReads.service.RecenzijaService;
import WebProjekat.GoodReads.service.ZanrService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/knjige")
public class KnjigaKontroler {
    @Autowired
    private KnjigaService knjigaService;
    @Autowired
    private ZanrService zanrService;

//TODO change returning object to KnjigaDto, as well as all returning objects
    @GetMapping("/{id}")
    public ResponseEntity<KnjigaDto> findById(@PathVariable Long id){
        Knjiga knjiga = knjigaService.findById(id);
        KnjigaDto knjigaDto = new KnjigaDto(knjiga);
        return new ResponseEntity<KnjigaDto>(knjigaDto,HttpStatus.OK);
    }
    @PostMapping("/addGenre/")
    public ResponseEntity<String> addGenre(@RequestParam Long zanrId, @RequestParam Long knjigaId, HttpSession session){
        Korisnik korisnik =(Korisnik) session.getAttribute("korisnik");
        if(korisnik == null) return new ResponseEntity<String>("Niste ulogovani", HttpStatus.BAD_REQUEST);
        if (korisnik.getUloga()!= Uloga.ADMINISTRATOR) return new ResponseEntity<String>("Morate biti administrator",HttpStatus.BAD_REQUEST);
        if(knjigaService.findById(knjigaId) == null){
            return new ResponseEntity<String>("Ne postoji knjiga sa unetim ID-jem", HttpStatus.BAD_REQUEST);
        }
        if(zanrService.findById(zanrId) == null){
            return new ResponseEntity<String>("Ne postoji zanr sa unetim ID-jem", HttpStatus.BAD_REQUEST);
        }
        knjigaService.addGenre(zanrId, knjigaId);
        return new ResponseEntity<String>("Uspesno ste dodali zanr na knjigu",HttpStatus.OK);
    }
}
