package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.repository.ContractRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContractTypePerServiceProviderImpl implements ContractTypePerServiceProvider {

    private ContractRepositoryInterface contractRepositoryInterface;

    @Override
    public Map<String, Map<String, Integer>> getContractTypePerServiceProvider() {

        List<Contract> contractsList = contractRepositoryInterface.getAllContracts();

        Map<String, Map<String, Integer>> contractTypePerServiceProvider = new HashMap<>();

        List<String> listOfProviders = new ArrayList<>();

        for (Contract contract : contractsList) {
            listOfProviders.add(contract.getPruzateljUsluge().getNaziv());
        }
        List<String> cleanListOfProviders = listOfProviders.stream().distinct().collect(Collectors.toList());

        for (String providerName : cleanListOfProviders) {

            Integer fixed = 0;
            Integer indefinite = 0;
            Map<String, Integer> contractsNumbers = new HashMap<>();

            for (Contract contract : contractsList) {
                if (providerName.equals(contract.getPruzateljUsluge().getNaziv())) {
                    if (contract.getTip().equals("FIXED")) {
                        fixed++;
                    } else if (contract.getTip().equals("INDEFINITE")) {
                        indefinite++;
                    }
                }
            }
            contractsNumbers.put("FIXED", fixed);
            contractsNumbers.put("INDEFINITE", indefinite);

            contractTypePerServiceProvider.put(providerName, contractsNumbers);
        }

        return contractTypePerServiceProvider;
    }
}