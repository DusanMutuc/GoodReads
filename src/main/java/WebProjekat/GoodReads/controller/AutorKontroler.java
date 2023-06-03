package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorKontroler {
    @Autowired
    private AutorService autorService;
}
