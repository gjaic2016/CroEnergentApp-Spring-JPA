package hr.apisit.energent.repository;

import hr.apisit.energent.domain.Owner;
import java.util.List;
import java.util.Optional;

public interface OwnerRepositoryInterface {

    List<Owner> getAllOwners();

    Optional<Owner> getOwnerById(Integer id);

    void saveNewOwner(Owner newOwner);

    Optional<Owner> updateOwner(Owner updatedOwner, Integer id);

    void deleteOwner(Integer id);
}
