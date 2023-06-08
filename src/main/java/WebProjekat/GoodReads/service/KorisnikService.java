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


    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }
    public Korisnik findById(Long Id){
        return korisnikRepository.findById(Id).orElse(null);
    }
    public Korisnik findByKorisnickoIme(String korisnickoIme){
        return korisnikRepository.findByKorisnickoIme(korisnickoIme).orElse(null);
    }
    public Korisnik findByEmail(String email){
        return korisnikRepository.findByEmail(email).orElse(null);
    }
    public Korisnik login(String email, String lozinka){
        Korisnik korisnik= korisnikRepository.findByEmail(email).orElse(null);
        if(korisnik != null){
            if(korisnik.getLozinka().equals(lozinka)){
                return korisnik;
            }
        }
        return null;
    }
    public void delete(Long id){
        korisnikRepository.deleteById(id);
    }
}
