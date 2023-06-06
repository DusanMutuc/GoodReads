package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.LoginDto;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.repository.KorisnikRepository;
import WebProjekat.GoodReads.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KorisnikKontroler {
    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto, HttpSession session){
        Korisnik korisnik = korisnikService.login(dto.getEmail(),dto.getLozinka());
        if(korisnik == null){
            return new ResponseEntity<String>("Podaci se ne poklapaju sa nalogom u sistemu", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("korisnik",korisnik);
        return new ResponseEntity<String>("Uspesno prijavljeni",HttpStatus.OK);
    }
}
