package priv.sin.librarylabsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sin.librarylabsproject.model.Book;
import priv.sin.librarylabsproject.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Didn't provide an id to find the book");
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book with id " + id + " not found"));
    }

    public void addBookToLibrary(Integer bookId, Integer libraryId, LibraryService libraryService) {
        Book book = findById(bookId);
        libraryService.addBook(book, libraryId);
    }
}
