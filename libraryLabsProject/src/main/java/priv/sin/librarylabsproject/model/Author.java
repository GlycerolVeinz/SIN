package priv.sin.librarylabsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "contracts")
    private List<Publisher> publishers;

    @ManyToMany(mappedBy = "authorship")
    private List<Book> books;
}