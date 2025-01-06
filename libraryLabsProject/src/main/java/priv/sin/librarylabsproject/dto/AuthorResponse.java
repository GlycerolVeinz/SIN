package priv.sin.librarylabsproject.dto;

import lombok.Data;

@Data
public class AuthorResponse {
    private Integer id;
    private String name;
    private String surname;
    private String email;
}

// This is a POJO class that represents the AuthorResponse object.
// We get this class when we want to send information about the author to the client.