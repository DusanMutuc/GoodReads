package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ZanrRepository extends JpaRepository<Zanr, Long> {
    Optional<Zanr> findByNaziv(String naziv);

}
