package hr.apisit.energent.reportcontroller;

import hr.apisit.energent.reportservice.MostExpensiveServiceReport;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("energent/mostExpensiveService")
@AllArgsConstructor
public class MostExpensiveServiceReportController {

    private MostExpensiveServiceReport mostExpensiveServiceReport;

    @GetMapping
    public ResponseEntity<?> getMostExpensiveService(){
        return ResponseEntity.status(HttpStatus.OK).body(mostExpensiveServiceReport.mostExpensiveService());
    }
}
