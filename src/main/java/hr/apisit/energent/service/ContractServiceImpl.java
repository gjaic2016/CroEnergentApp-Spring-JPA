package hr.apisit.energent.service;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.jpaRepository.ContractRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {

    private ContractRepositoryJpa contractRepositoryJpa;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepositoryJpa.findAll();
    }

    @Override
    public Optional<Contract> getContractById(Integer id) {
        return contractRepositoryJpa.findById(id);
    }

    @Override
    public void saveContract(Contract newContract) {
        contractRepositoryJpa.save(newContract);
    }

    @Override
    public Optional<Contract> updateContract(Contract updatedContract, Integer id) {
        //TODO contract update
//        return contractRepositoryInterface.updateContract(updatedContract, id);
        return null;
    }

    @Override
    public void deleteContract(Integer id) {
        contractRepositoryJpa.delete(getContractById(id).get());
    }
}
