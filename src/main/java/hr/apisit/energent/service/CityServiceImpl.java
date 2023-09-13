package hr.apisit.energent.service;

import hr.apisit.energent.domain.City;
import hr.apisit.energent.jpaRepository.CityRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepositoryJpa cityRepositoryJpa;

    @Override
    public List<City> getAllCities() {
        return cityRepositoryJpa.findAll();
    }

    @Override
    public Optional<City> getCityById(Integer id) {
        return cityRepositoryJpa.findById(id);
    }

    @Override
    public void saveCity(City newCity) {
        cityRepositoryJpa.save(newCity);
    }

    @Override
    public Optional<City> updateCity(City cityToUpdate, Integer originalCityId) {
        return Optional.empty();
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepositoryJpa.delete(getCityById(id).get());
    }

}
