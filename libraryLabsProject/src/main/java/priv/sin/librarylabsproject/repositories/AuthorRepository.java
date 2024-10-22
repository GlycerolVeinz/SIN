package priv.sin.librarylabsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.sin.librarylabsproject.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}