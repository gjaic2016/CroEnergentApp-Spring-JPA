package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.repository.ContractRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@AllArgsConstructor
public class MostIndefiniteContractsPerHouseholdImpl implements MostIndefiniteContractsPerHousehold{

    private ContractRepositoryInterface contractRepositoryInterface;

    @Override
    public Map<String, Integer> getMostIndefiniteContractsPerHousehold() {

        List<Contract> contractsList = contractRepositoryInterface.getAllContracts();

        Map<String, Integer> listOfMostIndefiniteContractsPerHousehold = new TreeMap<>();

        for (Contract contract : contractsList) {
            String householdAdress = contract.getKucanstvo().getAdresa();

            Integer sumOfContracts = 0;

            for (Contract c : contractsList) {
                if (householdAdress.equals(c.getKucanstvo().getAdresa())
                        && c.getTip().equals("INDEFINITE")) {
                    sumOfContracts++;
                }
            }

            listOfMostIndefiniteContractsPerHousehold.put(householdAdress, sumOfContracts);
        }
        return listOfMostIndefiniteContractsPerHousehold;
    }
}
