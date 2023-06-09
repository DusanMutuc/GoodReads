package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Polica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PolicaRepository extends JpaRepository<Polica,Long> {
    Set<Polica> findByNaziv(String naziv);
    void deleteByNaziv(String naziv);
}
