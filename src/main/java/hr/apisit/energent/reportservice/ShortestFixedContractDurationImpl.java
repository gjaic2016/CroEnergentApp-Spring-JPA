package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.domain.FixedTermContract;
import hr.apisit.energent.repository.ContractRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@AllArgsConstructor
public class ShortestFixedContractDurationImpl implements ShortestFixedContractDuration {

    private ContractRepositoryInterface contractRepositoryInterface;

    @Override
    public Contract getShortestFixedContractDuration() {

        List<Contract> contractsList = contractRepositoryInterface.getAllContracts();

        List<Contract> fixedContractList = new ArrayList<>();

        for (Contract contract : contractsList) {
            if (contract instanceof FixedTermContract) {
                fixedContractList.add(contract);
            }
        }

        List<Long> days = new ArrayList<>();

        for (Contract fixedContract : fixedContractList) {
            LocalDate startDate = ((FixedTermContract) fixedContract).getContractStart();
            LocalDate endDate = ((FixedTermContract) fixedContract).getContractEnd();
            days.add(ChronoUnit.DAYS.between(startDate, endDate));
        }

        Long shortestduration = Collections.min(days);
        
        Contract shortestContract = null;
        for (Contract fixedContract : fixedContractList) {
            LocalDate startDate = ((FixedTermContract) fixedContract).getContractStart();
            LocalDate endDate = ((FixedTermContract) fixedContract).getContractEnd();
            long day = ChronoUnit.DAYS.between(startDate, endDate);
            if(shortestduration.equals(day))
                 shortestContract = fixedContract;
        }

        return shortestContract;
    }
}
