package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoryJpa extends JpaRepository<Country,Integer> {
}
