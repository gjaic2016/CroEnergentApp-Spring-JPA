package hr.apisit.energent.controller;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.service.ServiceProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("energent/serviceprovider")
@AllArgsConstructor
public class ServiceProviderController {

    private ServiceProviderService serviceProviderService;

    @GetMapping
    public ResponseEntity<?> getServiceProviders(){
        return ResponseEntity.status(HttpStatus.OK).body(serviceProviderService.getAllServiceProviders());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getServiceProviderById(@PathVariable Integer id){
        ServiceProvider optionalServiceProvider = serviceProviderService.getServiceProviderById(id);

//        if(optionalServiceProvider.isPresent()){
//            return ResponseEntity.status(HttpStatus.OK).body(optionalServiceProvider.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
            return ResponseEntity.status(HttpStatus.OK).body(optionalServiceProvider);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewServiceProvider(@RequestBody ServiceProvider newServiceProvider) {
        serviceProviderService.saveNewServiceProvider(newServiceProvider);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateServiceProvider(@RequestBody ServiceProvider updatedSProvider, @PathVariable Integer id){
        ServiceProvider updatedServiceProviderOptional =
                serviceProviderService.updateServiceProvider(updatedSProvider, id);

            return ResponseEntity.status(HttpStatus.OK).body(updatedServiceProviderOptional);
//        if(updatedServiceProviderOptional.isPresent()){
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceProvider(@PathVariable Integer id){
        serviceProviderService.deleteServiceProvider(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
