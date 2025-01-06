package priv.sin.librarylabsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.sin.librarylabsproject.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

// This interface extends JpaRepository,
// which is a Spring Data interface that provides CRUD operations for the Author entity.
// So it's like a DAO (Data Access Object) for the Author entity.