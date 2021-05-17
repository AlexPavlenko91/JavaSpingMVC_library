package library.models;




import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Transactional
@Entity
@Table(name = "libraries")
public class Library extends BaseEntity{
    private String name;
    private String city;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libraries_books",
            joinColumns = @JoinColumn(name = "id_library"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    private Set<Book>books = new HashSet<>();

    public Library() {
    }

    public Library(String name, String city) {
        this.name = name;
        this.city = city;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public void addBook(Book book) {
        this.books.add(book);
    }

}
