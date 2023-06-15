package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.KnjigaDto;
import WebProjekat.GoodReads.dto.RecenzijaDto;
import WebProjekat.GoodReads.dto.ZanrDto;
import WebProjekat.GoodReads.entity.*;
import WebProjekat.GoodReads.repository.KnjigaRepository;
import WebProjekat.GoodReads.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/knjige")
public class KnjigaKontroler {
    @Autowired
    private KnjigaService knjigaService;
    @Autowired
    private ZanrService zanrService;
    @Autowired
    private RecenzijaService recenzijaService;
    @Autowired
    private StavkaService stavkaService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private PolicaService policaService;

    @GetMapping("/{id}")
    public ResponseEntity<KnjigaDto> findById(@PathVariable Long id){
        Knjiga knjiga = knjigaService.findById(id);
        if(knjiga == null ) return new ResponseEntity<KnjigaDto>(new KnjigaDto(),HttpStatus.BAD_REQUEST);
        KnjigaDto dto = new KnjigaDto(knjiga);
        return new ResponseEntity<KnjigaDto>(dto,HttpStatus.OK);
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
    @GetMapping("/{id}/recenzije")
    public ResponseEntity<List<RecenzijaDto>> ispisiRecenzije(@PathVariable Long id){
        List<RecenzijaDto> recenzije = stavkaService.recenzije(id);
        return new ResponseEntity<List<RecenzijaDto>>(recenzije,HttpStatus.OK);
    }
    @PostMapping("/dodaj")
    public ResponseEntity<String> dodajKnjigu(@RequestBody KnjigaDto dto,HttpSession session){
        Autor autor = (Autor) session.getAttribute("korisnik");
        if(autor == null){
            return new ResponseEntity<String>("Niste ulogovani!", HttpStatus.BAD_REQUEST);
        }
        if(autor.getUloga().equals(Uloga.CITALAC)){
            return new ResponseEntity<String>("Dodavanje knjiga nije dozvoljeno citaocima",HttpStatus.FORBIDDEN);
        }
        if(knjigaService.findByISBN(dto.getIsbn()) != null){
            return new ResponseEntity<String>("Knjiga sa tim ISBN-om vec postoji!", HttpStatus.BAD_REQUEST);
        }

        Knjiga knjiga = new Knjiga(dto);

        if(autor.getUloga().equals(Uloga.AUTOR)){
            Set<Knjiga> knjige= autor.getSpisakKnjiga();
            knjige.add(knjiga);
            autor.setSpisakKnjiga(knjige);
            autorService.save(autor);
            return new ResponseEntity<String>("Uspesno ste dodali knjigu, Autore!",HttpStatus.OK);
        }
        knjigaService.save(knjiga);
        return new ResponseEntity<String>("Uspesno ste dodali knjigu",HttpStatus.OK);


    }
    @GetMapping("izlistajSve")
    public ResponseEntity<List<Knjiga>> izlistajSve(){
        return new ResponseEntity<List<Knjiga>>(knjigaService.findAll(),HttpStatus.OK);
    }
    @GetMapping("izlistajSveSaPolice")
    public ResponseEntity<List<Knjiga>> izlistajSveSaPolice(@RequestParam Long policaId){
        if(policaService.findById(policaId) == null){
            List<Knjiga> knjige = new ArrayList<>();
            return new ResponseEntity<List<Knjiga>>(knjige,HttpStatus.BAD_REQUEST);
        }
        List<Knjiga> knjige = new ArrayList<>();
        Polica  polica = policaService.findById(policaId);
        for(Stavka stavka : polica.getStavke()){
            knjige.add(stavka.getKnjiga());
        }
        return new ResponseEntity<List<Knjiga>>(knjige,HttpStatus.OK);
    }
}
