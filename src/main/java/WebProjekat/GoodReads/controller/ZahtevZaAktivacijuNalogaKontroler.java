package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.ZahtevZaAktivacijuNalogaDto;
import WebProjekat.GoodReads.dto.ZahtevZaAktivacijuNalogaDto;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.ZahtevZaAktivacijuNaloga;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.repository.ZahtevZaAktivacijuNalogaRepository;
import WebProjekat.GoodReads.service.AutorService;
import WebProjekat.GoodReads.service.ZahtevZaAktivacijuNalogaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zahtevi")
public class ZahtevZaAktivacijuNalogaKontroler {
    @Autowired
    private ZahtevZaAktivacijuNalogaService zahtevZaAktivacijuNalogaService;
    @Autowired
    private AutorService autorService;

    @GetMapping("/{id}")
    public ResponseEntity<ZahtevZaAktivacijuNalogaDto> findById(@PathVariable Long id){
        ZahtevZaAktivacijuNaloga zahtevZaAktivacijuNaloga = zahtevZaAktivacijuNalogaService.findById(id);
        if(zahtevZaAktivacijuNaloga == null ) return new ResponseEntity<ZahtevZaAktivacijuNalogaDto>(new ZahtevZaAktivacijuNalogaDto(),HttpStatus.BAD_REQUEST);
        ZahtevZaAktivacijuNalogaDto dto = new ZahtevZaAktivacijuNalogaDto(zahtevZaAktivacijuNaloga);
        return new ResponseEntity<ZahtevZaAktivacijuNalogaDto>(dto,HttpStatus.OK);

    }
    @PostMapping("/aktivacija")
    public ResponseEntity<String> podnesiZahtev(@RequestBody ZahtevZaAktivacijuNalogaDto dto, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik != null) return new ResponseEntity<String>("Morate biti neprijavljeni", HttpStatus.BAD_REQUEST);

        ZahtevZaAktivacijuNaloga zahtevZaAktivacijuNaloga = new ZahtevZaAktivacijuNaloga(dto);
        zahtevZaAktivacijuNaloga.setAutor(autorService.findById(dto.getIdAutor()));
        zahtevZaAktivacijuNaloga =zahtevZaAktivacijuNalogaService.save(zahtevZaAktivacijuNaloga);
        return new ResponseEntity<String>("Uspesno ste podneli zahtev!",HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ZahtevZaAktivacijuNaloga>> findAll(){
        return new ResponseEntity<List<ZahtevZaAktivacijuNaloga>>(zahtevZaAktivacijuNalogaService.findAll(),HttpStatus.OK);
    }
}
