package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.dto.LoginDto;
import WebProjekat.GoodReads.dto.RegisterDto;
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
    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto dto,HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if(korisnik!=null) return new ResponseEntity<String>("Vec ste prijavljeni",HttpStatus.BAD_REQUEST);
        if(korisnikService.findByKorisnickoIme(dto.getKorisnickoIme()) != null){
            return new ResponseEntity<String>("Postoji nalog sa tim korisnickim imenom",HttpStatus.BAD_REQUEST);
        }
        if(korisnikService.findByEmail(dto.getMail()) != null){
            return new ResponseEntity<String>("Postoji nalog sa tim emailom",HttpStatus.BAD_REQUEST);
        }
        if(dto.getLozinka().equals(dto.getLozinkaConfirmation())) {
            return new ResponseEntity<String>("Uspesno ste registrovani", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Lozinke se ne poklapaju",HttpStatus.BAD_REQUEST);
    }
}
