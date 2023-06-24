package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Knjiga;
import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Recenzija;
import WebProjekat.GoodReads.entity.Stavka;
import WebProjekat.GoodReads.repository.RecenzijaRepository;
import WebProjekat.GoodReads.repository.StavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;
    @Autowired
    private StavkaRepository stavkaRepository;

    public Recenzija save(String tekst, Float ocena, Korisnik korisnik){
        Recenzija recenzija = new Recenzija();
        recenzija.setOcena(ocena);
        recenzija.setTekst(tekst);
        recenzija.setKorisnik(korisnik);
        recenzija.setDatumRecenzije(new Date());
        recenzija = recenzijaRepository.save(recenzija);
        return recenzija;
    }
    public List<Recenzija> recenzijeOdKnjige(Knjiga knjiga){
        List<Recenzija> recenzije = new ArrayList<>();
        for(Stavka stavka : stavkaRepository.findAllByKnjigaID(knjiga.getID())) {
            recenzije.add(stavka.getRecenzija());
        }
        return recenzije;
    }
    public Recenzija findById(long id){
        return recenzijaRepository.findById(id).orElse(null);
    }


}
