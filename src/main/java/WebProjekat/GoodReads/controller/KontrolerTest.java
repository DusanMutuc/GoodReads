package WebProjekat.GoodReads.controller;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class KontrolerTest {
    @Autowired
    private Test servis;
    @GetMapping("/")
    public String home(){
        return "Hello world!";
    }
    @PostMapping("/")
    public String home1(){
        return "Goodbye world!";
    }
    @PostMapping("/api/login")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password){
        return servis.login(username,password);
    }
}
