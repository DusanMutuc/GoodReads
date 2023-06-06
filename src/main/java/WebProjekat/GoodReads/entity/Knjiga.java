package WebProjekat.GoodReads.entity;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Knjiga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String naslov;
    private String naslovnaFotografija;
    @Column(unique = true)
    private String ISBN;
    private Date datumObjavljivanja;
    private Integer brojStrana;
    private String opis;

    @ManyToMany
    private  Set<Zanr> Zanr = new HashSet<>();
    private Float ocena;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        naslovnaFotografija = naslovnaFotografija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(String datumObjavljivanja) {
        datumObjavljivanja = datumObjavljivanja;
    }

    public Integer getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(Integer brojStrana) {
        brojStrana = brojStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        opis = opis;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        ocena = ocena;
    }

    public Set<WebProjekat.GoodReads.entity.Zanr> getZanr() {
        return Zanr;
    }

    public void setZanr(Set<WebProjekat.GoodReads.entity.Zanr> zanr) {
        Zanr = zanr;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "ID=" + ID +
                ", Naslov='" + naslov + '\'' +
                ", NaslovnaFotografija='" + naslovnaFotografija + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", DatumObjavljivanja='" + datumObjavljivanja + '\'' +
                ", BrojStrana=" + brojStrana +
                ", Opis='" + opis + '\'' +
                ", Ocena=" + ocena +
                '}';
    }
}
