package priv.sin.librarylabsproject.service;

import priv.sin.librarylabsproject.model.Author;
import priv.sin.librarylabsproject.model.Publisher;

public interface AuthorService {
    Author findById(Integer id);

    void makeContract(Author author, Integer publisherId, PublisherService publisherService);

    Author updateContract(Author author, Publisher publisher);

}
