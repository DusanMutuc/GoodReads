package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Stavka implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne
    private Knjiga knjiga;

    @OneToOne
    private Recenzija recenzija;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }
}
