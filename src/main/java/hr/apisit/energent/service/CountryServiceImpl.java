package hr.apisit.energent.service;

import hr.apisit.energent.domain.Country;
import hr.apisit.energent.jpaRepository.CountryRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{

    private CountryRepositoryJpa countryRepositoryJpa;

    @Override
    public List<Country> getAllCountries() {
        return countryRepositoryJpa.findAll();
    }
}
