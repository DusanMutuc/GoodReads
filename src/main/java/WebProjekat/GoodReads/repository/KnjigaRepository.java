package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
}
