package hr.apisit.energent.service;

import hr.apisit.energent.domain.ContractType;
import hr.apisit.energent.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface ContractTypeService {

    List<ContractType> getAllContractTypes();

    Optional<ContractType> getContractTypeById(Integer id);

    void saveContractType(ContractType newContractType);

    ContractType updateContractType(ContractType updatedContractType, Integer id);

    void deleteContractType(Integer id);

}
