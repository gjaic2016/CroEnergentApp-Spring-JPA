package hr.apisit.energent.controller;

import hr.apisit.energent.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("energent/address")
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> getAddresses(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
    }
}
