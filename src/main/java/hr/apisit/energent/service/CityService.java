package hr.apisit.energent.service;

import hr.apisit.energent.domain.City;


import java.util.List;
import java.util.Optional;

public interface CityService{

    List<City> getAllCities();


    Optional<City> getCityById(Integer id);

    void saveCity(City newCity);

    Optional<City> updateCity(City updatedCity, Integer id);

    void deleteCity(Integer id);

}
