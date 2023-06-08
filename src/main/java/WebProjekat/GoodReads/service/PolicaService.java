package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Polica;
import WebProjekat.GoodReads.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    public Polica save(Polica polica){
        return policaRepository.save(polica);
    }
    public Polica findById(Long id){
        return policaRepository.findById(id).orElse(null);
    }
    public Set<Polica> savePrimary(){
        Set<Polica> police = new HashSet<>();
        Polica wantToRead = new Polica("Want to Read",true);
        Polica currentlyReading = new Polica("Currently Reading", true);
        Polica read = new Polica("Read",true);
        police.add(wantToRead);
        police.add(currentlyReading);
        police.add(read);
        return police;
    }
    public Boolean containsPolicaByName(Set<Polica> police,String name){
        for(Polica polica : police){
            if(polica.getNaziv().equals(name)) return true;
        }
        return false;
    }
    public Polica findByNaziv(String naziv){
        return policaRepository.findByNaziv(naziv);
    }
    public Polica findByNazivInKorisnik(Set<Polica> police, String naziv){
        for(Polica polica : police){
            if(polica.getNaziv().equals(naziv) ){
                return polica;
            }
        }
        return null;
    }

}
