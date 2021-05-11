package library.controllers;

import library.models.Library;
import library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/libraries", method = RequestMethod.GET)
public class LibraryController {
    List<Library> libraries = new ArrayList<>();

    private LibraryService libraryService;

    @Autowired
    public void setService(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping({""})
    public String showLibraries(Model model) {

        model.addAttribute("librariesAll", libraryService.getAllLibraries());

        return "libraries";
    }
    @GetMapping( "/id={id}")
    public String showLibraryById(@PathVariable(name = "id", required = false)@Nullable Long id,
                                Model model) {
        Library library = new Library("Central region", "Zhytomyr");
        Library library1 = libraryService.getById(id);
        model.addAttribute("library", library);
        libraries.add(library);
        libraries.add(library1);
        model.addAttribute("librariesAll", libraryService.getAllLibraries());
        System.out.println(library1);
        //studentMap.put("students", students);
        return "libraries";
    }

    @GetMapping(value = "/new_lib")
    public String newLibrary() {
        return "new_library";
    }

    @PostMapping(value = "/new_post")
    public String newPostLibrary(@ModelAttribute Library library) {
        //students.add(student);
        libraryService.saveLibrary(library);
        return "redirect:/libraries";//вызов другого контроллера
    }
}
