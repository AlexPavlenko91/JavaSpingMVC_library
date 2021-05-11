package library.services;

import library.models.Library;
import library.repositories.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private LibraryRepo libraryRepo;

    @Autowired
    public void setLibraryRepo(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }



    public List<Library> getAllLibraries(){
        return libraryRepo.findAll();
    }

    public Library getById(Long id) {
        //return jdbcStudentDAO.getById(id);
        if (id == null) {
            return null;
        } else {
            return libraryRepo.getById(id);
        }

    }

    public Library saveLibrary(Library library) {
        return libraryRepo.saveAndFlush(library);
    }
}
