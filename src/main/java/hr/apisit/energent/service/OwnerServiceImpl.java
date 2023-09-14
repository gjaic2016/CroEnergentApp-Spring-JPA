package hr.apisit.energent.service;

import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.jpaRepository.OwnerRepositoryJpa;
import hr.apisit.energent.repository.OwnerRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService{


//    private OwnerRepositoryInterface ownerRepositoryInterface;

    private OwnerRepositoryJpa ownerRepositoryJpa;

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepositoryJpa.findAll();
//        return ownerRepositoryInterface.getAllOwners();
    }

    @Override
    public Optional<Owner> getOwnerById(Integer id) {
        return ownerRepositoryJpa.findById(id);
//        return ownerRepositoryInterface.getOwnerById(id);
    }

    @Override
    public void saveOwner(Owner newOwner) {
        ownerRepositoryJpa.save(newOwner);
//        ownerRepositoryInterface.saveNewOwner(newOwner);
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
            throw new EntityNotFoundException("There is no Seat object for ID = '" + originalOwnerId + "'");
        }

//        return Optional.of(ownerRepositoryJpa.save(ownerToUpdate));
//        return ownerRepositoryInterface.updateOwner(ownerToUpdate, originalOwnerId);
    }

//    @Override
//    public void deleteOwner(Integer id) {
//          ownerRepositoryInterface.deleteOwner(id);
//    }


    @Override
    public void deleteOwner(Owner owner) {
        ownerRepositoryJpa.delete(owner);
    }
}
