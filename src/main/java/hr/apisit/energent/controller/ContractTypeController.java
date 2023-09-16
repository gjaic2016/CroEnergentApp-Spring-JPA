package hr.apisit.energent.controller;

import hr.apisit.energent.domain.City;
import hr.apisit.energent.domain.ContractType;
import hr.apisit.energent.domain.ServiceType;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.service.ContractTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/contractType")
@AllArgsConstructor
public class ContractTypeController {

    private ContractTypeService contractTypeService;

    @GetMapping
    public ResponseEntity<?> getContractTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(contractTypeService.getAllContractTypes());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getContractTypeById(@PathVariable Integer id){
        Optional<ContractType> optionalContractType = contractTypeService.getContractTypeById(id);
        if (optionalContractType.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalContractType.get());
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewContractType(@RequestBody ContractType newContractType) {
        contractTypeService.saveContractType(newContractType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateContractType(@RequestBody ContractType updatedContractType, @PathVariable Integer id){

        try{
            ContractType newUpdatedContractType = contractTypeService.updateContractType(updatedContractType, id);
            return ResponseEntity.status(HttpStatus.OK).body(newUpdatedContractType);
        }catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContractType(@PathVariable Integer id){
        contractTypeService.deleteContractType(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
