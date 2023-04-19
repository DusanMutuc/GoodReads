package WebProjekat.GoodReads.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Recenzija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private Long ocena;
    private String tekst;
    private String datumRecenzije;
    //TODO veza izmedju korisnika


}
