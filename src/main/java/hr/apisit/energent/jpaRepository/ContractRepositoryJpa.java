package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepositoryJpa extends JpaRepository<Contract, Integer> {
}
