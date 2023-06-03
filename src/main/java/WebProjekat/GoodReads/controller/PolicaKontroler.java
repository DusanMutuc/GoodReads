package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.service.PolicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicaKontroler {
    @Autowired
    private PolicaService policaService;
}
