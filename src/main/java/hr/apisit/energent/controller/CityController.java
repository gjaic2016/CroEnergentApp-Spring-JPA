package hr.apisit.energent.controller;

import hr.apisit.energent.domain.City;
import hr.apisit.energent.domain.Household;
import hr.apisit.energent.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/city")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @GetMapping
    public ResponseEntity<?> getCities(){
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getAllCities());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getCityById(@PathVariable Integer id){
        Optional<City> optionalCity = cityService.getCityById(id);
        if (optionalCity.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalCity.get());
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewCity(@RequestBody City newCity) {
        cityService.saveCity(newCity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateCity(@RequestBody City updatedCity, @PathVariable Integer id){
        Optional<City> updatedCityOptional =
                cityService.updateCity(updatedCity, id);

        if(updatedCityOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(updatedCityOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Integer id){
        cityService.deleteCity(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
