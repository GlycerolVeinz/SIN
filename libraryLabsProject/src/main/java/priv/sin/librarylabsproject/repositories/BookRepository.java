package priv.sin.librarylabsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.sin.librarylabsproject.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}