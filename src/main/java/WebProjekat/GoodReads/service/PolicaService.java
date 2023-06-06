package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Polica;
import WebProjekat.GoodReads.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    public Polica save(Polica polica){
        return policaRepository.save(polica);
    }
    public Polica findById(Long id){
        return policaRepository.findById(id).orElse(null);
    }
}
