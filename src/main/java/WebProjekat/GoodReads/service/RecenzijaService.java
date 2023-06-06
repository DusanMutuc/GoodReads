package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Recenzija;
import WebProjekat.GoodReads.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public Recenzija save(String tekst, Float ocena, Korisnik korisnik){
        Recenzija recenzija = new Recenzija();
        recenzija.setOcena(ocena);
        recenzija.setTekst(tekst);
        recenzija.setKorisnik(korisnik);
        recenzija.setDatumRecenzije(new Date());
        recenzija = recenzijaRepository.save(recenzija);
        return recenzija;
    }
    public Recenzija findByID(long id){
        return recenzijaRepository.findById(id).orElse(null);
    }
    public void  delete(Long id) { recenzijaRepository.deleteById(id);}

}
