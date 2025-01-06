package priv.sin.librarylabsproject.service;

import priv.sin.librarylabsproject.model.Book;
import priv.sin.librarylabsproject.model.Library;

public interface LibraryService {
    Library findById(Integer id);
    void addBook(Book book, Integer libraryId);
}
