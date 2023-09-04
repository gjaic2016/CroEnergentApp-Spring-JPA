package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.repository.ContractRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TotalServiceCostPerHouseholdReportImpl implements TotalServiceCostPerHouseholdReport {

    private ContractRepositoryInterface contractRepositoryInterface;

    @Override
    public Map<String, BigDecimal> totalServiceCostPerHousehold() {

        List<Contract> contractsList = contractRepositoryInterface.getAllContracts();

        Map<String, BigDecimal> listOfTotalCostPerHousehold = new HashMap<>();

        for (Contract contract : contractsList) {
            String householdAdress = contract.getKucanstvo().getAdresa();

            BigDecimal sumPrice = new BigDecimal(0);

            for (Contract c : contractsList) {
                if (householdAdress.equals(c.getKucanstvo().getAdresa())) {
                    sumPrice = sumPrice.add(c.getPruzateljUsluge().getCijenaUsluge());
                }
            }
            listOfTotalCostPerHousehold.put(householdAdress, sumPrice);
        }
        return listOfTotalCostPerHousehold;
    }
}
