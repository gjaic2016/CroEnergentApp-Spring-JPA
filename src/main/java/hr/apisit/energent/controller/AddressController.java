package hr.apisit.energent.controller;

import hr.apisit.energent.domain.Address;
import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.jpaRepository.AddressRepositoryJpa;
import hr.apisit.energent.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("energent/address")
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;



    @GetMapping
    public ResponseEntity<?> getAddresses(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getAddressById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAddress(@RequestBody Address newAddress) {
        addressService.saveAddress(newAddress);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
