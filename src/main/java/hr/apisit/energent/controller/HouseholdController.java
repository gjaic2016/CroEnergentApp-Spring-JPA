package hr.apisit.energent.controller;

import hr.apisit.energent.domain.Household;
import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.service.HouseholdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/household")
@AllArgsConstructor
public class HouseholdController {

    private HouseholdService householdService;

    @GetMapping
    public ResponseEntity<?> getHouseholds(){
        return ResponseEntity.status(HttpStatus.OK).body(householdService.getAllHouseholds());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getOwnerById(@PathVariable Integer id){
        Optional<Household> optionalHousehold = householdService.getHouseholdById(id);

        if(optionalHousehold.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalHousehold.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewHousehold(@RequestBody Household newHousehold) {
        householdService.saveHousehold(newHousehold);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateHousehold(@RequestBody Household updatedHousehold, @PathVariable Integer id){
        Optional<Household> updatedHouseholdOptional =
                householdService.updateHousehold(updatedHousehold, id);

        if(updatedHouseholdOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(updatedHouseholdOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHousehold(@PathVariable Integer id){
        householdService.deleteHousehold(householdService.getHouseholdById(id).get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
