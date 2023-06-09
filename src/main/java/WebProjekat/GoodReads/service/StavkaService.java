package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.dto.RecenzijaDto;
import WebProjekat.GoodReads.entity.Recenzija;
import WebProjekat.GoodReads.entity.Stavka;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.repository.StavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StavkaService {

    @Autowired
    private StavkaRepository stavkaRepository;

    public Stavka findById(Long id){
        return stavkaRepository.findById(id).orElse(null);
    }
    public List<Stavka> findByKnjigaId(Long id){
        return stavkaRepository.findByKnjigaID(id);
    }
    public List<RecenzijaDto> recenzije(Long id){
        List<Stavka> stavke =stavkaRepository.findByKnjigaID(id);
        List<RecenzijaDto> recenzije = new ArrayList<>();
        for(Stavka stavka : stavke){
            if(stavka.getRecenzija()!=null)
            recenzije.add(new RecenzijaDto(stavka.getRecenzija()));
        }
        return recenzije;
    }
    public void delete(Long id){
        stavkaRepository.deleteById(id);
    }




}
