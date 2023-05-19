package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {
}
