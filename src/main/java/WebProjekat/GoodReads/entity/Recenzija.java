package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.Set;
import java.util.HashSet;
@Entity
public class Recenzija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private Long ocena;
    private String tekst;
    private String datumRecenzije;


    //Umesto stavke police pravimo veze u samoj recenziji, ima mi vise smisla ovako jer
    //Stavka police = knjiga + recenzija, sto mozemo postici samo dodavanjem veze sa knjigom u recenziji
    @OneToOne
    private Korisnik korisnik;
    @OneToOne
    private Knjiga knjiga;

    //veza izmedju recenzije i police
    @ManyToMany
    private Set<Polica> polica = new HashSet<>();


}
