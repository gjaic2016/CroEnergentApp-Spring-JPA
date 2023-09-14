package hr.apisit.energent.service;

import hr.apisit.energent.domain.Address;
import hr.apisit.energent.domain.City;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> getAllAddresses();

    Optional<Address> getAddressById(Integer id);

    void saveAddress(Address newAddress);

    Optional<Address> updateAddress(Address updatedAddress, Integer id);

    void deleteAddress(Integer id);


}
