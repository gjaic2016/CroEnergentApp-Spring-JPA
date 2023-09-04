package hr.apisit.energent.service;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.domain.Household;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    List<Contract> getAllContracts();

    Optional<Contract> getContractById(Integer id);

    void saveContract(Contract newContract);

    Optional<Contract> updateContract(Contract updatedContract, Integer id);

    void deleteContract(Integer id);

}
