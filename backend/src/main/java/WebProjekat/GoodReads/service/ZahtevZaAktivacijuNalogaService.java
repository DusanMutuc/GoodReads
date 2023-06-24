package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Autor;
import WebProjekat.GoodReads.entity.Status;
import WebProjekat.GoodReads.entity.ZahtevZaAktivacijuNaloga;
import WebProjekat.GoodReads.repository.AutorRepository;
import WebProjekat.GoodReads.repository.ZahtevZaAktivacijuNalogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZahtevZaAktivacijuNalogaService {
    @Autowired
    private ZahtevZaAktivacijuNalogaRepository zahtevZaAktivacijuNalogaRepository;
    @Autowired
    private AutorRepository autorRepository;

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

    public void odobri(ZahtevZaAktivacijuNaloga zahtev, Boolean odobreno) {
        Autor autor = zahtev.getAutor();
        if (odobreno) {
            autor.setEmail(zahtev.getEmail());
            autor.setAktivan(true);
            zahtev.setStatus(Status.ODOBREN);
        } else {
            autor.setAktivan(false);
            zahtev.setStatus(Status.ODBIJEN);
        }
        zahtevZaAktivacijuNalogaRepository.save(zahtev);
        autorRepository.save(autor);
    }


}
