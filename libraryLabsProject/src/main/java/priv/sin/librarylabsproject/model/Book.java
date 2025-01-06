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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "authorship",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authorship;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book other))
            return false;
        return this.id.equals(other.id);
    }
}