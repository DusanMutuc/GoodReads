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
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @OneToMany
    private Set <Polica> police = new HashSet<>();

    public Korisnik(){
        Polica p1 = new Polica("Want to read",true);
        Polica p2 = new Polica("Currently Reading",true);
        Polica p3 = new Polica("Read", true);
        police.add(p1);
        police.add(p2);
        police.add(p3);
    }



}
