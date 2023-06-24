package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Polica;
import WebProjekat.GoodReads.entity.Uloga;
import jakarta.persistence.Column;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class KorisnikDto {
    private Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private Date datumRodjenja;
    private String profilnaSlika;
    private String opis;
    private Set<Polica> police = new HashSet<>();
    private String cookie;
    private Uloga uloga;

    public KorisnikDto(Korisnik korisnik){
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.datumRodjenja = korisnik.getDatumRodjenja();
        this.profilnaSlika = korisnik.getProfilnaSlika();
        this.opis = korisnik.getOpis();
        this.police=korisnik.getPolice();
        this.uloga = korisnik.getUloga();
        this.id = korisnik.getID();
    }

    public KorisnikDto(Korisnik korisnik, String id){
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.datumRodjenja = korisnik.getDatumRodjenja();
        this.profilnaSlika = korisnik.getProfilnaSlika();
        this.opis = korisnik.getOpis();
        this.police=korisnik.getPolice();
        this.cookie = id;
        this.uloga = korisnik.getUloga();
        this.id = korisnik.getID();
    }
    public KorisnikDto(){

    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getProfilnaSlika() {
        return profilnaSlika;
    }

    public void setProfilnaSlika(String profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<Polica> getPolice() {
        return police;
    }

    public void setPolice(Set<Polica> police) {
        this.police = police;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
