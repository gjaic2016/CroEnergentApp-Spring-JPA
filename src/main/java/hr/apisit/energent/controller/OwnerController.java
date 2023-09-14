package hr.apisit.energent.controller;

import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/owner")
@AllArgsConstructor
public class OwnerController {

    private OwnerService ownerService;

    @GetMapping
    public ResponseEntity<?> getOwners(){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.getAllOwners());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getOwnerById(@PathVariable Integer id){
        Optional<Owner> optionalOwner = ownerService.getOwnerById(id);

        if(optionalOwner.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalOwner.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewOwner(@RequestBody Owner newOwner) {
        ownerService.saveOwner(newOwner);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateOwner(@RequestBody Owner updatedOwner, @PathVariable Integer id){

        try{
            Owner newUpdatedOwner = ownerService.updateOwner(updatedOwner, id);
            return ResponseEntity.status(HttpStatus.OK).body(newUpdatedOwner);
        }catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

//        if(updatedOwnerOptional.isPresent()){
//            return ResponseEntity.status(HttpStatus.OK).body(updatedOwnerOptional.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Integer id){
        ownerService.deleteOwner(ownerService.getOwnerById(id).get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
