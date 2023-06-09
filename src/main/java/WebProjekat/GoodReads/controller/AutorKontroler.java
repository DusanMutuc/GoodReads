package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorKontroler {
    @Autowired
    private AutorService autorService;

    @PostMapping("/api/knjige/azuriraj")
    public ResponseEntity<String> azurirajKnjigu(){


        return new ResponseEntity<String>("bla", HttpStatus.OK);
    }
}
