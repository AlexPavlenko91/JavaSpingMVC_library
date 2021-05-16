package library.controllers;

import library.models.Author;
import library.models.Book;
import library.models.Library;
import library.services.AuthorService;
import library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/authors", method = RequestMethod.GET)
public class AuthorController {

    List<Author> authors = new ArrayList<>();

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping({""})
    public String showAuthors(Model model) {

        model.addAttribute("authorsAll", authorService.getAllAuthors());

        return "authors";
    }

    @PostMapping(value = "/new_auth")
    public String newPostAuthor(@ModelAttribute Author author) {
        //students.add(student);
        authorService.saveAuthor(author);
        return "redirect:/authors";//вызов другого контроллера
    }

    @PostMapping(value = "/remove_author")
    public String removePostAuthor(@RequestParam Long id, @ModelAttribute Author author) {
        authorService.removeAuthor(authorService.getAuthorById(id));
        return "redirect:/authors";
    }
}
