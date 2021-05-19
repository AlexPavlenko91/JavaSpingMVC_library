package library.controllers;

import library.models.Author;
import library.models.Book;
import library.models.Library;
import library.services.AuthorService;
import library.services.BookService;
import library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/libraries", method = RequestMethod.GET)
public class LibraryController {
    private List<Library> libraries;
    private List<Author> authors;

    @Autowired
    public void setLibraries(LibraryService libraryService) {
        this.libraries = libraryService.getAllLibraries();
    }

    @Autowired
    public void setAuthors(AuthorService authorService) {
        this.authors = authorService.getAllAuthors();
    }

    private LibraryService libraryService;
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

    @Autowired
    public void setService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping({""})
    public String showLibraries(Model model) {

        model.addAttribute("librariesAll", libraryService.getAllLibraries());
        model.addAttribute("newAuthor", new Author());
        model.addAttribute("booksAll", bookService.getAllBooks());
        model.addAttribute("authorsAll", authorService.getAllAuthors());
        return "libraries";
    }


    @PostMapping(value = "/show_lib")
    public String showPostLibrary(Model model, @RequestParam(name = "id") Long id) {
        Library library = libraries.stream().filter(lib -> lib.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("libraryById", library);
        return "show_library";
    }

    @GetMapping(value = "/new_lib")
    public String newLibrary() {
        return "new_library";
    }


    @PostMapping(value = "/new_post")
    public String newPostLibrary(@ModelAttribute Library library) {
        libraryService.saveLibrary(library);
        return "redirect:/libraries";//вызов другого контроллера
    }

    @PostMapping(value = "/new_book")
    public String newPostBookToLibrary(@RequestParam(name = "idAuthor") Long idAuthor, @ModelAttribute Book book,
                                       @RequestParam(name = "idLib") Long idLib) {
       /* Author author = authors.stream().filter(a -> a.getId().equals(idAuthor))
                .findFirst()
                .orElse(null);*/
    
        book.setAuthor(authorService.getAuthorById(idAuthor));

        Library library = libraries.stream().filter(lib -> lib.getId().equals(idLib))
                .findAny()
                .orElse(null);

        if (library != null) {
            library.addBook(book);
            book.setLibraries(Set.of(library));
        }
        bookService.saveBook(book);
        libraryService.saveLibrary(library);
        return "redirect:/libraries";
    }

    @PostMapping(value = "/remove_library")
    public String removePostLibrary(@RequestParam Long id) {
        libraryService.removeLibrary(libraryService.getById(id));
        return "redirect:/libraries";
    }
}
