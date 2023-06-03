package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Test {
    @Autowired
    private KorisnikRepository korisnikRepository;
    public ResponseEntity login(String username, String pass){
         Korisnik korisnik = korisnikRepository.findByKorisnickoIme(username);
         if (korisnik.getLozinka().equals(pass)){
            return new ResponseEntity(korisnik, HttpStatus.OK);
         }
         else return new ResponseEntity("Nije dobra lozinka",HttpStatus.FORBIDDEN);
    }
}
