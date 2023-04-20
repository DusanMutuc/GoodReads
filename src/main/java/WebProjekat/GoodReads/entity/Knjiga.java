package WebProjekat.GoodReads.entity;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Knjiga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String Naslov;
    private String NaslovnaFotografija;
    @Column(unique = true)
    private String ISBN;
    private String DatumObjavljivanja;
    private Long BrojStrana;
    private String Opis;

    @ManyToMany
    private  Set<Zanr> Zanr = new HashSet<>();
    @ManyToMany
    private Set<Polica> polica = new HashSet<>();
    private double Ocena;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNaslov() {
        return Naslov;
    }

    public void setNaslov(String naslov) {
        Naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return NaslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        NaslovnaFotografija = naslovnaFotografija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDatumObjavljivanja() {
        return DatumObjavljivanja;
    }

    public void setDatumObjavljivanja(String datumObjavljivanja) {
        DatumObjavljivanja = datumObjavljivanja;
    }

    public Long getBrojStrana() {
        return BrojStrana;
    }

    public void setBrojStrana(Long brojStrana) {
        BrojStrana = brojStrana;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public Double getOcena() {
        return Ocena;
    }

    public void setOcena(Double ocena) {
        Ocena = ocena;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "ID=" + ID +
                ", Naslov='" + Naslov + '\'' +
                ", NaslovnaFotografija='" + NaslovnaFotografija + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", DatumObjavljivanja='" + DatumObjavljivanja + '\'' +
                ", BrojStrana=" + BrojStrana +
                ", Opis='" + Opis + '\'' +
                ", Ocena=" + Ocena +
                '}';
    }
}
