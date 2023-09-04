package hr.apisit.energent.reportcontroller;


import hr.apisit.energent.reportservice.MostIndefiniteContractsPerHousehold;
import hr.apisit.energent.reportservice.MostIndefiniteContractsPerHouseholdImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("energent/mostIndefiniteContractsPerHousehold")
@AllArgsConstructor
public class MostIndefiniteContractsPerHouseholdController {

    private MostIndefiniteContractsPerHousehold mostIndefiniteContractsPerHousehold;

    @GetMapping
    public ResponseEntity<?> getMostIndefiniteContractsPerHousehold(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(mostIndefiniteContractsPerHousehold.getMostIndefiniteContractsPerHousehold());
    }

}
