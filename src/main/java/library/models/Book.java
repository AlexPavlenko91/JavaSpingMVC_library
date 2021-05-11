package library.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name="id_author")
    private Author author;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="id_library")
    private Library library;

    public Book() {
    }




}
