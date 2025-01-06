package priv.sin.librarylabsproject.service;

import priv.sin.librarylabsproject.model.Author;
import priv.sin.librarylabsproject.model.Publisher;

public interface AuthorService {
    Author findById(Integer id);

    Author updateContract(Author author, Publisher publisher);

}
