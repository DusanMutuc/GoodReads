package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.entity.Stavka;
import WebProjekat.GoodReads.repository.StavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StavkaService {

    @Autowired
    private StavkaRepository stavkaRepository;

    public Stavka findById(Long id){
        return stavkaRepository.findById(id).orElse(null);
    }

}
