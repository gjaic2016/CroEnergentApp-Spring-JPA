package hr.apisit.energent.service;

import hr.apisit.energent.domain.ContractType;
import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.jpaRepository.ContractTypeRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractTypeImpl implements ContractTypeService{

    private ContractTypeRepositoryJpa contractTypeRepositoryJpa;

    @Override
    public List<ContractType> getAllContractTypes() {
        return contractTypeRepositoryJpa.findAll();
    }

    @Override
    public Optional<ContractType> getContractTypeById(Integer id) {
        return contractTypeRepositoryJpa.findById(id);
    }

    @Override
    public void saveContractType(ContractType newContractType) {
        contractTypeRepositoryJpa.save(newContractType);
    }

    @Override
    public ContractType updateContractType(ContractType contractTypeToUpdate, Integer originalContractTypeId) {
        Optional<ContractType> modifiedContractTypeOptional = contractTypeRepositoryJpa.findById(originalContractTypeId);

        if(modifiedContractTypeOptional.isPresent()) {
            ContractType modifiedContractType = modifiedContractTypeOptional.get();

            modifiedContractType.setName(contractTypeToUpdate.getName());

            ContractType newUpdatedContractType = contractTypeRepositoryJpa.save(modifiedContractType);

            return newUpdatedContractType;
        }
        else {
            throw new EntityNotFoundException("There is no ContractType object for ID = '" + originalContractTypeId + "'");
        }
    }

    @Override
    public void deleteContractType(Integer id) {
        contractTypeRepositoryJpa.delete(getContractTypeById(id).get());
    }
}
