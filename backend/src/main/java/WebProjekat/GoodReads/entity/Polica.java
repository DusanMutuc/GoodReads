package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Polica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String naziv;
    private Boolean primarna;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "polica_ID")
    private Set<Stavka> stavke = new HashSet<>();

    public Polica(String naziv, Boolean primarna, Set<Stavka> stavke) {
        this.naziv = naziv;
        this.primarna = primarna;
        this.stavke = stavke;
    }

    public Polica(String naziv, Boolean primarna) {
        this.naziv = naziv;
        this.primarna = primarna;
    }

    public Polica(){

    }
    public Polica(String naziv){
        this.naziv = naziv;
        this.primarna = false;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getPrimarna() {
        return primarna;
    }

    public void setPrimarna(Boolean primarna) {
        this.primarna = primarna;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Set<Stavka> getStavke() {
        return stavke;
    }

    public void setStavke(Set<Stavka> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Polica{" +
                "ID=" + ID +
                ", Naziv='" + naziv + '\'' +
                ", Primarna=" + primarna +
                '}';
    }
}
