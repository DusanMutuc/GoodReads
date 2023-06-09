package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.dto.KorisnikDto;
import WebProjekat.GoodReads.entity.Autor;
import WebProjekat.GoodReads.repository.AutorRepository;
import WebProjekat.GoodReads.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Autor azuriraj(KorisnikDto dto,Long autorId){
        Autor autor = findById(autorId);
        if(dto.getDatumRodjenja() !=null){
            autor.setDatumRodjenja(dto.getDatumRodjenja());
        }
        if(dto.getIme() != null){
            autor.setIme(dto.getIme());
        }
        if(dto.getOpis() != null){
            autor.setOpis(dto.getOpis());
        }
        if(dto.getPrezime() != null){
            autor.setPrezime(dto.getPrezime());
        }
        if(dto.getKorisnickoIme()!= null){
            autor.setKorisnickoIme(dto.getKorisnickoIme());
        }
        if(dto.getProfilnaSlika()!= null){
            autor.setProfilnaSlika(dto.getProfilnaSlika());
        }
        return autorRepository.save(autor);
    }
    public Autor findById(Long id){
        return autorRepository.findById(id).orElse(null);
    }
    public Autor save(Autor autor){
            return autorRepository.save(autor);
    }

    public void delete(Long id){
        autorRepository.deleteById(id);
    }
}
