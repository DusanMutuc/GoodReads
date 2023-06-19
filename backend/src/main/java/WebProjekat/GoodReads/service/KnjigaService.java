package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.dto.KnjigaDto;
import WebProjekat.GoodReads.entity.Knjiga;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.repository.KnjigaRepository;
import WebProjekat.GoodReads.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private ZanrService zanrService;
    public Knjiga findById(Long id) { return knjigaRepository.findById(id).orElse(null);}
    public void addGenre(Long knjigaId, Long zanrId) {
        Set<Zanr> zanrovi = new HashSet<>();
        Knjiga knjiga = knjigaRepository.findById(knjigaId).orElse(null);
        Zanr zanr = zanrService.findById(zanrId);
        zanrovi = knjiga.getZanr();
        zanrovi.add(zanr);
        knjiga.setZanr(zanrovi);
        knjigaRepository.save(knjiga);
    }
    public Knjiga save(Knjiga knjiga){
        return knjigaRepository.save(knjiga);
    }
    public void delete(Long id){
        knjigaRepository.deleteById(id);
    }
    public Knjiga findByISBN(String isbn){
        return knjigaRepository.findByIsbn(isbn);
    }

    public Knjiga azuriraj( Integer brojStrana, String naslov,  String opis,  String naslovnaFotografija, Long knjigaId){
        Knjiga knjiga = knjigaRepository.findById(knjigaId).orElse(null);
        if(brojStrana != null){
            knjiga.setBrojStrana(brojStrana);
        }
        if(naslov != null){
            knjiga.setNaslov(naslov);
        }
        if(opis!= null){
            knjiga.setOpis(opis);
        }
        if(naslovnaFotografija != null){
            knjiga.setNaslovnaFotografija(naslovnaFotografija);
        }
        return knjigaRepository.save(knjiga);
    }
    public List<Knjiga> findByZanr(Zanr zanr){
        List<Knjiga> knjige = new ArrayList<>();
        for(Knjiga knjiga : knjigaRepository.findAll()){
            for(Zanr zanr1 : knjiga.getZanr()){
                if(zanr1.getNaziv().equals(zanr.getNaziv())){
                    knjige.add(knjiga);
                }
            }
        }
        return knjige;
    }
    public List<Knjiga> findAll(){
        return knjigaRepository.findAll();
    }
    public Knjiga findByNaslov(String naslov){
        return knjigaRepository.findByNaslov(naslov).orElse(null);
    }
}
