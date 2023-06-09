package WebProjekat.GoodReads.repository;

import WebProjekat.GoodReads.entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
    public Knjiga findByIsbn(String isbn);
}
