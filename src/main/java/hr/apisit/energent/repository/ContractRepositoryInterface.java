package hr.apisit.energent.repository;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.domain.Owner;
import java.util.List;
import java.util.Optional;

public interface ContractRepositoryInterface {

    List<Contract> getAllContracts();

    Optional<Contract> getContractById(Integer id);

    void saveNewcontract(Contract newContract);

    Optional<Contract> updateContract(Contract updatedContract, Integer id);

    void deleteContract(Integer id);

}
