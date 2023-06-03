package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.repository.StavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StavkaService {

    @Autowired
    private StavkaRepository stavkaRepository;
}
