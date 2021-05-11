package library.services;

import library.models.Author;
import library.models.Book;
import library.models.Library;
import library.repositories.AuthorRepo;
import library.repositories.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepo authorRepo;

    @Autowired
    public void setAuthorRepo(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }

    public Author saveAuthor(Author author) {
        return authorRepo.saveAndFlush(author);
    }


    public Author getAuthorById(Long id) {
        return authorRepo.getById(id);
    }
}
