package priv.sin.librarylabsproject.service;

import priv.sin.librarylabsproject.model.Book;

public interface BookService {
    Book findById(Integer id);

    void addBookToLibrary(Integer bookId, Integer libraryId, LibraryService libraryService);
}
