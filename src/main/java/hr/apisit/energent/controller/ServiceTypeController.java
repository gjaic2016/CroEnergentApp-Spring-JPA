package hr.apisit.energent.controller;

import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.domain.ServiceType;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.service.ServiceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/serviceType")
@AllArgsConstructor
public class ServiceTypeController {

    private ServiceTypeService serviceTypeService;

    @GetMapping
    public ResponseEntity<?> getServiceTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(serviceTypeService.getAllServiceTypes());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getServiceTypeById(@PathVariable Integer id){
        Optional<ServiceType> optionalServiceType = serviceTypeService.getServiceTypeById(id);
        if (optionalServiceType.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalServiceType.get());
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewServiceType(@RequestBody ServiceType newServiceType) {
        serviceTypeService.saveServiceType(newServiceType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateServiceType(@RequestBody ServiceType updatedServiceTape, @PathVariable Integer id){

        try{
            ServiceType newUpdatedServiceType = serviceTypeService.updateServiceType(updatedServiceTape, id);
            return ResponseEntity.status(HttpStatus.OK).body(newUpdatedServiceType);
        }catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceType(@PathVariable Integer id){
        serviceTypeService.deleteServiceType(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
