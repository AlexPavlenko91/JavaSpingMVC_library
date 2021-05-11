package library.repositories;

import library.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {
    public Library findByName(String libraryName);
    public Library getById(long id);
    //void saveLibrary(Library library);
}