package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepositoryJpa extends JpaRepository<City, Integer> {
}
