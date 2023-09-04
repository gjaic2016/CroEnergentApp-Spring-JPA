package hr.apisit.energent.reportcontroller;

import hr.apisit.energent.reportservice.ShortestFixedContractDuration;
import hr.apisit.energent.reportservice.SortedServiceProvidersByAdressReport;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("energent/shortestFixedContract")
@AllArgsConstructor
public class ShortestFixedContractDurationController {

    private ShortestFixedContractDuration shortestFixedContractDuration;

    @GetMapping
    public ResponseEntity<?> getShortestFixedContract(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(shortestFixedContractDuration.getShortestFixedContractDuration());
    }
}
