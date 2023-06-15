package WebProjekat.GoodReads.entity;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import WebProjekat.GoodReads.dto.RegisterDto;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String ime;
    private String prezime;
    @Column(unique = true)
    private String korisnickoIme;
    @Column(unique = true)
    private String email;
    private String lozinka;
    private Date datumRodjenja;
    private String profilnaSlika;
    private String opis;
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "korisnikID",nullable = false)
    private Set <Polica> police = new HashSet<>();

    public Korisnik(RegisterDto dto){
        this.ime = dto.getIme();
        this.prezime = dto.getPrezime();
        this.korisnickoIme = dto.getKorisnickoIme();
        this.email = dto.getMail();
        this.lozinka = dto.getLozinka();
    }
    public Korisnik(){

    }
    public Long getID() {return ID;}

    public void setID(Long ID) {
        this.ID = ID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Set<Polica> getPolice() {
        return police;
    }

    public void setPolice(Set<Polica> police) {
        this.police = police;
    }
}