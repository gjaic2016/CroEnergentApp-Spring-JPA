package hr.apisit.energent.reportcontroller;

import hr.apisit.energent.reportservice.TotalServiceCostPerHouseholdReport;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("energent/totalServiceCostPerHousehold")
@AllArgsConstructor
public class TotalServiceCostPerHouseholdReportController {

    private TotalServiceCostPerHouseholdReport totalServiceCostPerHouseholdReport;

    @GetMapping
    public ResponseEntity<?> getContractTypePerServiceProvider(){
        return ResponseEntity.status(HttpStatus.OK).body(totalServiceCostPerHouseholdReport.totalServiceCostPerHousehold());
    }

}
