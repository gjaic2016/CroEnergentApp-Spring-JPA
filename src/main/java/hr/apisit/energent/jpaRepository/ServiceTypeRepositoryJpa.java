package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepositoryJpa extends JpaRepository<ServiceType, Integer> {
}
