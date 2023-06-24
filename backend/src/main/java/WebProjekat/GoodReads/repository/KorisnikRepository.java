package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Optional<Korisnik> findByKorisnickoIme(String username);
    Optional<Korisnik> findByEmail(String email);
    List<Korisnik> findAllByPrezime(String prezime);

}
