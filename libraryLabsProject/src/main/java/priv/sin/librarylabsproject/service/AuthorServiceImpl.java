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
    public void makeContract(Author author, Integer publisherId, PublisherService publisherService) {
        Publisher publisher = publisherService.findById(publisherId);
        Publisher publisherUpdated = publisherService.updateContract(publisher, author);
        Author authorUpdated = updateContract(author, publisher);

        if (!(authorUpdated != null && publisherUpdated != null)) {
            throw new RuntimeException("Failed to make contract between author and publisher");
        }
    }

    @Override
    public Author updateContract(Author author, Publisher publisher) {
        author.getPublishers().add(publisher);
        return authorRepository.save(author);
    }


}
