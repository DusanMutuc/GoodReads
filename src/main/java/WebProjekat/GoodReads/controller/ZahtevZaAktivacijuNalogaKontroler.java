package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.repository.ZahtevZaAktivacijuNalogaRepository;
import WebProjekat.GoodReads.service.ZahtevZaAktivacijuNalogaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZahtevZaAktivacijuNalogaKontroler {
    @Autowired
    private ZahtevZaAktivacijuNalogaService zahtevZaAktivacijuNalogaService;
}
