package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Autor;
import WebProjekat.GoodReads.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor findById(Long id){
        return autorRepository.findById(id).orElse(null);
    }
    public void save(){

    }
    public void delete(Long id){
        autorRepository.deleteById(id);
    }
}
