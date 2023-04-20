package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    private Autor autor;
}
