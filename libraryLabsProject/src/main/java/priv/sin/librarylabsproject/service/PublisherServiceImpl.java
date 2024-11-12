package priv.sin.librarylabsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sin.librarylabsproject.model.Author;
import priv.sin.librarylabsproject.model.Publisher;
import priv.sin.librarylabsproject.repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService{
    PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher findById(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Didn't provide an id to find the publisher");
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher with id " + id + " not found"));
    }

    @Override
    public void makeContract(Publisher publisher, Integer authorId, AuthorService authorService) {
        Author author = authorService.findById(authorId);
        Author authorUpdated = authorService.updateContract(author, publisher);
        Publisher publisherUpdated = updateContract(publisher, author);

        if (!(authorUpdated != null && publisherUpdated != null)) {
            throw new RuntimeException("Failed to make contract between author and publisher");
        }
    }

    @Override
    public Publisher updateContract(Publisher publisher, Author authorId) {
        publisher.getContracts().add(authorId);
        return publisherRepository.save(publisher);
    }
}
