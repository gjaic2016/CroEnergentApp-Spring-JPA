package hr.apisit.energent.service;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.repository.ContractRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService{

    private ContractRepositoryInterface contractRepositoryInterface;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepositoryInterface.getAllContracts();
    }

    @Override
    public Optional<Contract> getContractById(Integer id) {
        return contractRepositoryInterface.getContractById(id);
    }

    @Override
    public void saveContract(Contract newContract) {
        contractRepositoryInterface.saveNewcontract(newContract);
    }

    @Override
    public Optional<Contract> updateContract(Contract updatedContract, Integer id) {
        return contractRepositoryInterface.updateContract(updatedContract, id);
    }

    @Override
    public void deleteContract(Integer id) {
        contractRepositoryInterface.deleteContract(id);
    }
}
