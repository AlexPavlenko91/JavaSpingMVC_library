package library.repositories;

import library.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {
}
