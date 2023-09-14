package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryJpa extends JpaRepository<Address, Integer> {
}
