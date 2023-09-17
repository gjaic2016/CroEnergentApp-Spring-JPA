package hr.apisit.energent.controller;

import hr.apisit.energent.domain.City;
import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.domain.ServiceSP;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.service.ServiceSPService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/servicesp")
@AllArgsConstructor
public class ServiceSPController {

    private ServiceSPService serviceSPService;

    @GetMapping
    public ResponseEntity<?> getServicesSP(){
        return ResponseEntity.status(HttpStatus.OK).body(serviceSPService.getAllServices());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getServiceSPById(@PathVariable Integer id){
        Optional<ServiceSP> optionalServiceSP = serviceSPService.getServiceById(id);
        if (optionalServiceSP.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalServiceSP.get());
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewServiceSP(@RequestBody ServiceSP newServiceSP) {
        serviceSPService.saveService(newServiceSP);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateServiceSP(@RequestBody ServiceSP updatedServiceSP, @PathVariable Integer id){

        try{
            ServiceSP newUpdatedServiceSP = serviceSPService.updateService(updatedServiceSP, id);
            return ResponseEntity.status(HttpStatus.OK).body(newUpdatedServiceSP);
        }catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceSP(@PathVariable Integer id){
        serviceSPService.deleteService(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
