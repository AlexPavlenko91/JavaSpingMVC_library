package library.services;

import library.models.Book;
import library.models.Library;
import library.repositories.BookRepo;
import library.repositories.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    private BookRepo bookRepo;

    @Autowired
    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book saveBook(Book book){
       return bookRepo.saveAndFlush(book);
    }

    public void removeBook(Book book){
        bookRepo.delete(book);
    }

    public Book getBookById(Long id) {
        return bookRepo.getById(id);
    }


}
