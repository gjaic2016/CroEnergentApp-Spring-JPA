package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepositoryJpa extends JpaRepository<Household,Integer > {
}
