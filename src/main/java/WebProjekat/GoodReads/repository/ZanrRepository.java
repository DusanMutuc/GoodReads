package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ZanrRepository extends JpaRepository<Zanr, Long> {
    Optional<Zanr> findByNaziv(String naziv);

}
