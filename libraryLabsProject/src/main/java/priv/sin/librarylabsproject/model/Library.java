 package priv.sin.librarylabsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

 @Getter
@Setter
@Entity
@Table(name = "libraries")
public class Library {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "library_id")
    private Set<Book> books;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}