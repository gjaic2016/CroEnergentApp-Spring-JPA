package hr.apisit.energent.controller;

import hr.apisit.energent.domain.City;
import hr.apisit.energent.domain.Country;
import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getCountries(){
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getAllCountries());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getCountryById(@PathVariable Integer id){
        Optional<Country> optionalCountry = countryService.getCountryById(id);
        if (optionalCountry.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalCountry.get());
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewCountry(@RequestBody Country newCountry) {
        countryService.saveCountry(newCountry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateCountry(@RequestBody Country updatedCountry, @PathVariable Integer id){

        try{
            Country newUpdatedCountry = countryService.updateCountry(updatedCountry, id);
            return ResponseEntity.status(HttpStatus.OK).body(newUpdatedCountry);
        }catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Integer id){
        countryService.deleteCountry(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
