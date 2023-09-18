package hr.apisit.energent.service;

import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.jpaRepository.OwnerRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService{

    private OwnerRepositoryJpa ownerRepositoryJpa;

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepositoryJpa.findAll();
    }

    @Override
    public Optional<Owner> getOwnerById(Integer id) {
        return ownerRepositoryJpa.findById(id);
    }

    @Override
    public void saveOwner(Owner newOwner) {
        ownerRepositoryJpa.save(newOwner);
    }

    @Override
    public Owner updateOwner(Owner ownerToUpdate, Integer originalOwnerId) {

        Optional<Owner> modifiedOwnerOptional = ownerRepositoryJpa.findById(originalOwnerId);

        if(modifiedOwnerOptional.isPresent()) {
            Owner modifiedOwner = modifiedOwnerOptional.get();

            modifiedOwner.setIme(ownerToUpdate.getIme());
            modifiedOwner.setPrezime(ownerToUpdate.getPrezime());
            modifiedOwner.setDatumRodenja(ownerToUpdate.getDatumRodenja());
            modifiedOwner.setOib(ownerToUpdate.getOib());

            Owner newUpdatedOwner = ownerRepositoryJpa.save(modifiedOwner);

            return newUpdatedOwner;
        }
        else {
            throw new EntityNotFoundException("There is no Owner object for ID = '" + originalOwnerId + "'");
        }
    }

    @Override
    public void deleteOwner(Owner owner) {
        ownerRepositoryJpa.delete(owner);
    }
}
