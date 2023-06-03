package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;
}
