package priv.sin.librarylabsproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import priv.sin.librarylabsproject.model.Author;
import priv.sin.librarylabsproject.service.AuthorService;

@RestController("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id) {
        return authorService.findById(id);
    }
}

// This is a controller class that provides methods over authors, but for the client's side.