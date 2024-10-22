package priv.sin.librarylabsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "contracts",
        joinColumns = @JoinColumn(name = "publisher_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> contracts;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}