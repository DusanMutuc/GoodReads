package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
@Entity
public class Recenzija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private Float ocena;
    private String tekst;
    private Date datumRecenzije;

    @ManyToOne
    private Korisnik korisnik;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(Date datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
