package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.repository.ZahtevZaAktivacijuNalogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahtevZaAktivacijuNalogaService {
    @Autowired
    private ZahtevZaAktivacijuNalogaRepository zahtevZaAktivacijuNalogaRepository;
}
