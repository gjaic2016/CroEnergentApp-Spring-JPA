package hr.apisit.energent.service;

import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.repository.OwnerRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService{


    private OwnerRepositoryInterface ownerRepositoryInterface;

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepositoryInterface.getAllOwners();
    }

    @Override
    public Optional<Owner> getOwnerById(Integer id) {
        return ownerRepositoryInterface.getOwnerById(id);
    }

    @Override
    public void saveOwner(Owner newOwner) {
        ownerRepositoryInterface.saveNewOwner(newOwner);
    }

    @Override
    public Optional<Owner> updateOwner(Owner updatedOwner, Integer id) {
        return ownerRepositoryInterface.updateOwner(updatedOwner, id);
    }

    @Override
    public void deleteOwner(Integer id) {
        ownerRepositoryInterface.deleteOwner(id);
    }
}
