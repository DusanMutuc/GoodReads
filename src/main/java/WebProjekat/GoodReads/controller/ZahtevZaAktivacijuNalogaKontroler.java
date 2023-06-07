package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.ZahtevZaAktivacijuNalogaDto;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.ZahtevZaAktivacijuNaloga;
import WebProjekat.GoodReads.repository.ZahtevZaAktivacijuNalogaRepository;
import WebProjekat.GoodReads.service.ZahtevZaAktivacijuNalogaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zahtevi")
public class ZahtevZaAktivacijuNalogaKontroler {
    @Autowired
    private ZahtevZaAktivacijuNalogaService zahtevZaAktivacijuNalogaService;

    @GetMapping("/{id}")
    public ResponseEntity<ZahtevZaAktivacijuNaloga> findById(@PathVariable Long id){
        return new ResponseEntity<ZahtevZaAktivacijuNaloga>(zahtevZaAktivacijuNalogaService.findById(id), HttpStatus.OK);

    }
    @PostMapping("/aktivacija")
    public ResponseEntity<String> podnesiZahtev(@RequestBody ZahtevZaAktivacijuNalogaDto dto, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik != null) return new ResponseEntity<String>("Morate biti neprijavljeni", HttpStatus.BAD_REQUEST);

        ZahtevZaAktivacijuNaloga zahtevZaAktivacijuNaloga = new ZahtevZaAktivacijuNaloga(dto);
        zahtevZaAktivacijuNaloga =zahtevZaAktivacijuNalogaService.save(zahtevZaAktivacijuNaloga);
        return new ResponseEntity<String>("Uspesno ste podneli zahtev!",HttpStatus.OK);
    }
}
