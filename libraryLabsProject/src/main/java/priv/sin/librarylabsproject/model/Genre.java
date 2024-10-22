package priv.sin.librarylabsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Book> book;
}