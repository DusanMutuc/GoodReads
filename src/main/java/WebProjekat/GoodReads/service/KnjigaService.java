package WebProjekat.GoodReads.service;

import WebProjekat.GoodReads.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
}
