package priv.sin.librarylabsproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    private int id;

    @Column(name = "home_number")
    private Integer homeNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;
}