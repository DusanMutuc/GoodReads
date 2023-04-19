package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Zanr implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String naziv;


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


    @Override
    public String toString() {
        return "Zanr{" +
                "ID=" + ID +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
