package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.service.StavkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StavkaKontroler {
    @Autowired
    private StavkaService stavkaService;
}
