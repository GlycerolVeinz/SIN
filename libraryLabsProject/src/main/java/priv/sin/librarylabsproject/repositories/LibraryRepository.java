package priv.sin.librarylabsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.sin.librarylabsproject.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}