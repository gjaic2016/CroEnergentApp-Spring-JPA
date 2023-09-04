package hr.apisit.energent.reportcontroller;

import hr.apisit.energent.reportservice.GroupServiceProvidersByServiceTypeReport;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("energent/groupProvidersByType")
@AllArgsConstructor
public class GroupServiceProvidersByServiceTypeController {

    private GroupServiceProvidersByServiceTypeReport groupServiceProvidersByServiceTypeReport;

    @GetMapping
    public ResponseEntity<?> getGroupedServiceProvidersByType(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupServiceProvidersByServiceTypeReport.getGroupedSProvidersByServiceType());
    }
}
