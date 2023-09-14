package hr.apisit.energent.service;

import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.domain.ServiceProvider;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<Owner> getAllOwners();

    Optional<Owner> getOwnerById(Integer id);

    void saveOwner(Owner newOwner);

    Owner updateOwner(Owner updatedOwner, Integer id);

//    void deleteOwner(Integer id);

    void deleteOwner(Owner owner);
}
