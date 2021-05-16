package library.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(libraries, book.libraries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, libraries);
    }*/
/*public void setLibrary(Library library) {
        this.library = library;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



   /* @ManyToOne
    @JoinColumn(name="id_library")
    private Library library;*/

    public Book() {
    }




}
