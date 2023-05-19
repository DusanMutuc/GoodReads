package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Polica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String naziv;
    private Boolean primarna;

    @OneToMany
    @JoinColumn(name = "polica_ID")
    private List<Stavka> stavke = new ArrayList<>();



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

    @Override
    public String toString() {
        return "Polica{" +
                "ID=" + ID +
                ", Naziv='" + naziv + '\'' +
                ", Primarna=" + primarna +
                '}';
    }
}
