package library.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name="id_author")
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")

    Set<Library> libraries = new HashSet<>();

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {
    }

}
