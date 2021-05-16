package library.controllers;

import library.models.Author;
import library.models.Book;
import library.services.AuthorService;
import library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/books", method = RequestMethod.GET)
public class BookController {
    List<Book> books  = new ArrayList<>();

    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({""})
    public String showBooks(Model model) {
        model.addAttribute("newAuthor", new Author());
        model.addAttribute("booksAll", bookService.getAllBooks());
        model.addAttribute("authorsAll", authorService.getAllAuthors());
        return "books";
    }

    @PostMapping(value = "/new_book")
    public String newPostBook(@RequestParam Long id, @ModelAttribute Book book) {
        book.setAuthor(authorService.getAuthorById(id));
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping(value = "/remove_book")
    public String removePostBook(@RequestParam Long id) {
        bookService.removeBook(bookService.getBookById(id));
        return "redirect:/books";
    }
}
