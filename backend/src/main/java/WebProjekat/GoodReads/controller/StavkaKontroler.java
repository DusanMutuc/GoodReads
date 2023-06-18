package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.entity.Stavka;
import WebProjekat.GoodReads.service.StavkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
public class StavkaKontroler {
    @Autowired
    private StavkaService stavkaService;

    @GetMapping("api/stavke/findAll")
    public ResponseEntity<List<Stavka>> findAll(){
        return new ResponseEntity<List<Stavka>>(stavkaService.findAll(), HttpStatus.OK);
    }
}
