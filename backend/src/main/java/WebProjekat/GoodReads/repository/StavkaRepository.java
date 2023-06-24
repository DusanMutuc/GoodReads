package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Stavka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StavkaRepository extends JpaRepository<Stavka, Long> {
    List<Stavka> findAllByKnjigaID(Long id);

}
