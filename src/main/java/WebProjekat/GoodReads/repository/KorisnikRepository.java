package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByKorisnickoIme(String username);
}
