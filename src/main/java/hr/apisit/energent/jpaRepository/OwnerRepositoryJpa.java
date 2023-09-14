package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepositoryJpa extends JpaRepository<Owner, Integer> {
}
