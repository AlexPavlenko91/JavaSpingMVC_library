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


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.equals(city, library.city) && Objects.equals(authors, library.authors) && Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, authors, books);
    }*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libraries_books",
            joinColumns = @JoinColumn(name = "id_library"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    private Set<Book>books = new HashSet<>();
    /*@OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private Set<Book> books;*/

    public Library() {
    }

    public Library(String name, String city) {
        this.name = name;
        this.city = city;
    }

    /*@Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", authors=" + authors +
                ", books=" + books +
                '}';
    }*/

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


}
