package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.repository.KorisnikRepository;
import WebProjekat.GoodReads.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KorisnikKontroler {
    @Autowired
    private KorisnikService korisnikService;
}
