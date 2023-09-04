package hr.apisit.energent.reportcontroller;

import hr.apisit.energent.reportservice.SortedServiceProvidersByAdressReport;
import hr.apisit.energent.service.ServiceProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("energent/serviceproviderByAdress")
@AllArgsConstructor
public class SortedServiceProvidersByAddressController {

    private SortedServiceProvidersByAdressReport sortedServiceProvidersByAdressReport;

    @GetMapping
    public ResponseEntity<?> getServiceProvidersByAdress(){
        return ResponseEntity.status(HttpStatus.OK).body(sortedServiceProvidersByAdressReport.sortedServiceProvidersByAddress());
    }

}
