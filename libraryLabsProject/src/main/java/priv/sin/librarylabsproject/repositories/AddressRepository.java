package priv.sin.librarylabsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.sin.librarylabsproject.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}