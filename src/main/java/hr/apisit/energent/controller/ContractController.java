package hr.apisit.energent.controller;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("energent/contract")
@AllArgsConstructor
public class ContractController {

    private ContractService contractService;

    @GetMapping
    public ResponseEntity<?> getContracts(){
        return ResponseEntity.status(HttpStatus.OK).body(contractService.getAllContracts());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getOwnerById(@PathVariable Integer id){
        Optional<Contract> optionalContract = contractService.getContractById(id);

        if(optionalContract.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalContract.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewContract(@RequestBody Contract newContract) {
        contractService.saveContract(newContract);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateOwner(@RequestBody Contract updatedContract, @PathVariable Integer id){
        Optional<Contract> updatedContractOptional =
                contractService.updateContract(updatedContract, id);

        if(updatedContractOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(updatedContractOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable Integer id){
        contractService.deleteContract(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
