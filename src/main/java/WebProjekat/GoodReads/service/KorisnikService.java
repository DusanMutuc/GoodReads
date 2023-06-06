package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik login(String email, String lozinka){
        Korisnik korisnik= korisnikRepository.findByEmail(email);
        if(korisnik != null){
            if(korisnik.getLozinka().equals(lozinka)){
                return korisnik;
            }
        }
        return null;
    }
    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }
    public Korisnik findById(Long Id){
        return korisnikRepository.findById(Id).orElse(null);
    }
}
