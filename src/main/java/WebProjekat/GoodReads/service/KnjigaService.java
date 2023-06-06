package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Knjiga;
import WebProjekat.GoodReads.entity.Zanr;
import WebProjekat.GoodReads.repository.KnjigaRepository;
import WebProjekat.GoodReads.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
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
}
