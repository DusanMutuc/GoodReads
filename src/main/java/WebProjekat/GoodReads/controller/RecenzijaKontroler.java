package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecenzijaKontroler {
    @Autowired
    private RecenzijaService recenzijaService;
}
