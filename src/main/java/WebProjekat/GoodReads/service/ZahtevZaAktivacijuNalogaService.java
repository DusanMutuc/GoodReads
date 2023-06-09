package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.ZahtevZaAktivacijuNaloga;
import WebProjekat.GoodReads.repository.ZahtevZaAktivacijuNalogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZahtevZaAktivacijuNalogaService {
    @Autowired
    private ZahtevZaAktivacijuNalogaRepository zahtevZaAktivacijuNalogaRepository;

    public ZahtevZaAktivacijuNaloga findById(Long id){
        return zahtevZaAktivacijuNalogaRepository.findById(id).orElse(null);
    }
    public ZahtevZaAktivacijuNaloga save(ZahtevZaAktivacijuNaloga zahtevZaAktivacijuNaloga){
        return zahtevZaAktivacijuNalogaRepository.save(zahtevZaAktivacijuNaloga);
    }
    public void delete(Long id){
        zahtevZaAktivacijuNalogaRepository.deleteById(id);
    }
    public List<ZahtevZaAktivacijuNaloga> findAll(){
        return zahtevZaAktivacijuNalogaRepository.findAll();

    }


}
