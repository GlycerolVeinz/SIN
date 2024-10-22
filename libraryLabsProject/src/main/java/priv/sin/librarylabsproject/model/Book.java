package priv.sin.librarylabsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    private Integer id;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "name")
    private String name;

    @Column(name = "published")
    private Date published;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "authorship",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> author;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
}