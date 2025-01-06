package priv.sin.librarylabsproject.service;

import priv.sin.librarylabsproject.model.Author;
import priv.sin.librarylabsproject.model.Publisher;

public interface PublisherService {
    Publisher findById(Integer id);

    Publisher updateContract(Publisher publisher, Author authorId);

}
