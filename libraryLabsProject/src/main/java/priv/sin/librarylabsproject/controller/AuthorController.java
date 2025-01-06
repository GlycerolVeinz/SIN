package priv.sin.librarylabsproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import priv.sin.librarylabsproject.dto.AuthorResponse;
import priv.sin.librarylabsproject.dto.mapper.AuthorMapper;
import priv.sin.librarylabsproject.service.AuthorService;

@RestController("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable Integer id) {
        return authorMapper.toDTO(authorService.findById(id));
    }
}

// This is a controller class that provides methods over authors, but for the client's side.