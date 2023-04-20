package WebProjekat.GoodReads.entity;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.*;

import java.io.Serializable;
enum Uloga {
    Citalac,
    Autor,
    Administrator
}
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

    @OneToMany
    @JoinColumn(name = "korisnikID",nullable = false)
    private Set <Polica> police = new HashSet<>();






}
