package WebProjekat.GoodReads.entity;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

@Entity
public class Autor extends Korisnik implements Serializable {
    private Boolean aktivan;
    @OneToMany
    @JoinColumn(name = "autorID")
    private Set<Knjiga> spisakKnjiga= new HashSet<>();

    public Boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Set<Knjiga> getSpisakKnjiga() {
        return spisakKnjiga;
    }

    public void setSpisakKnjiga(Set<Knjiga> spisakKnjiga) {
        this.spisakKnjiga = spisakKnjiga;
    }
}
