package WebProjekat.GoodReads.entity;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

@Entity
public class Autor extends Korisnik implements Serializable {
    private boolean Aktivan;
    @OneToMany
    @JoinColumn(name = "autorID")
    private Set<Knjiga> spisakKnjiga= new HashSet<>();

    public boolean isAktivan() {
        return Aktivan;
    }

    public void setAktivan(boolean aktivan) {
        Aktivan = aktivan;
    }

    public Set<Knjiga> getSpisakKnjiga() {
        return spisakKnjiga;
    }

    public void setSpisakKnjiga(Set<Knjiga> spisakKnjiga) {
        this.spisakKnjiga = spisakKnjiga;
    }
}
