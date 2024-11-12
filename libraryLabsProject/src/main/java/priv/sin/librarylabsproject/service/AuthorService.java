package priv.sin.librarylabsproject.service;

import priv.sin.librarylabsproject.model.Author;

public interface AuthorService {
    Author findById(Integer id);

    Boolean makeContract(Author author, Integer publisherId);
}
