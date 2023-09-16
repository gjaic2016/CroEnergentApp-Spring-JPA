package hr.apisit.energent.service;

import hr.apisit.energent.domain.City;
import hr.apisit.energent.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> getAllCountries();

    Optional<Country> getCountryById(Integer id);

    void saveCountry(Country newCountry);

    Country updateCountry(Country updatedCountry, Integer id);

    void deleteCountry(Integer id);
}
