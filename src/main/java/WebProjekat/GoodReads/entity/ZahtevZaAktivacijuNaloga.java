package WebProjekat.GoodReads.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

enum Status{
    naCekanju,
    Odobren,
    odbijen
}
@Entity
public class ZahtevZaAktivacijuNaloga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String Email;
    private String Telefon;
    private String poruka;
    private String datum;
    private Status status;
}
