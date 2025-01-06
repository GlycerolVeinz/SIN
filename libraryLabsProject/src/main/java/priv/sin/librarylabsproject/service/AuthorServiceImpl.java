package priv.sin.librarylabsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sin.librarylabsproject.model.Author;
import priv.sin.librarylabsproject.model.Publisher;
import priv.sin.librarylabsproject.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;
    
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Didn't provide an id to find the author");
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author with id " + id + " not found"));
    }

    @Override
    public Author updateContract(Author author, Publisher publisher) {
        author.getPublishers().add(publisher);
        return authorRepository.save(author);
    }
}

// This is a service implementation that provides methods over authors.
// It's all the backend logic that is related to the author entity.
