package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.service.ZanrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZanrKontroler {
    @Autowired
    private ZanrService zanrService;
}
