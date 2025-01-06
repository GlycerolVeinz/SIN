package priv.sin.librarylabsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sin.librarylabsproject.model.Book;
import priv.sin.librarylabsproject.model.Library;
import priv.sin.librarylabsproject.repositories.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library findById(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("Didn't provide an id to find the library");
        return libraryRepository.findById(id).orElseThrow(() -> new RuntimeException("Library with id " + id + " not found"));
    }

    @Override
    public void addBook(Book book, Integer libraryId) {
        Library library = findById(libraryId);
        library.getBooks().add(book);
        libraryRepository.save(library);
    }

}
