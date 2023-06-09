package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Knjiga;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Polica;
import WebProjekat.GoodReads.entity.Stavka;
import WebProjekat.GoodReads.repository.KorisnikRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private KnjigaService knjigaService;


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

    public Korisnik addPolice(Set<Polica> police, Korisnik korisnik){
        korisnik.setPolice(police);
        return korisnik;
    }
    public Korisnik addPolica(Polica polica, Korisnik korisnik){
        Set<Polica> police = korisnik.getPolice();
        police.add(polica);
        korisnik.setPolice(police);
        return korisnik;
    }

    public Boolean primaryPoliceContainBook(Korisnik korisnik, Long knjigaId){
        for(Polica polica : korisnik.getPolice()){
            if(polica.getPrimarna()){
                for(Stavka stavka : polica.getStavke())
                    if(stavka.getKnjiga().getID().equals(knjigaId)){
                            return true;
                    }
            }
        }
        return false;
    }
    public void addBookToShelf(Korisnik korisnik,String policaIme, Long knjigaId){
        Polica polica1 = new Polica();
        for(Polica polica : korisnik.getPolice()){
            if(polica.getNaziv().equals(policaIme)){
                polica1 = polica;
            }
        }
        Stavka stavka1 = new Stavka(knjigaService.findById(knjigaId));
        List<Stavka> stavke = polica1.getStavke();
        stavke.add(stavka1);
        polica1.setStavke(stavke);

    }

    public void delete(Long id){
        korisnikRepository.deleteById(id);
    }

}
