package WebProjekat.GoodReads.entity;

import jakarta.persistence.*;

import java.io.Serializable;
enum Uloga {
    Citalac,
    Autor,
    Administrator
}
@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String ime;
    private String prezime;
    @Column(unique = true)
    private String korisnickoIme;
    @Column(unique = true)
    private String mailAdresa;
    private String lozinka;
    private String datumRodjenja;
    private String profilnaSlika;
    private String opis;
    private Uloga uloga;


}
