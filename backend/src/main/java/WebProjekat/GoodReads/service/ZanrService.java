package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Knjiga;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;

    public Zanr save(String naziv) {
        Zanr zanr = new Zanr();
        zanr.setNaziv(naziv);
        zanr = zanrRepository.save(zanr);
        return zanr;
    }
    public List<Zanr> findAll(){
        return zanrRepository.findAll();
    }
    public Zanr findById(Long id){
        return zanrRepository.findById(id).orElse(null);
    }
    public Zanr findByNaziv(String naziv){
        return zanrRepository.findByNaziv(naziv).orElse(null);
    }
    public Boolean exists(String naziv){
        return zanrRepository.findByNaziv(naziv).isPresent();
    }
    public void delete(Long id){
        zanrRepository.deleteById(id);
    }




}
