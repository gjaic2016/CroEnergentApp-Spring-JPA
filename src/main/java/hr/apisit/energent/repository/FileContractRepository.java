package hr.apisit.energent.repository;

import hr.apisit.energent.domain.*;
import hr.apisit.energent.utility.LocalDateUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FileContractRepository implements ContractRepositoryInterface {

    public static final Integer NUMBER_OF_CONTRACT_LINES = 6;
    public static final String CONTRACTS_FILE_NAME = "dat/contracts.txt";
    public static final String TEST_CONTRACTS_FILE_NAME = "dat/testContracts.txt";

    private ServiceProviderRepositoryInterface serviceProviderRepositoryInterface;

    private HouseholdRepositoryInterface householdRepositoryInterface;

    @Override
    public List<Contract> getAllContracts() {
        List<Contract> contractList = new ArrayList<>();

        Path stageFilePath = Path.of(CONTRACTS_FILE_NAME);

        List<String> lines;
        try {
            lines = Files.readAllLines(stageFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < lines.size() / NUMBER_OF_CONTRACT_LINES; i++) {

            Integer contractId = Integer.parseInt(lines.get(i * NUMBER_OF_CONTRACT_LINES));             //line 0 id

            String contractType = lines.get(i * NUMBER_OF_CONTRACT_LINES + 1);                          //line 1 type

            Integer serviceProviderId = Integer.parseInt(lines.get(i * NUMBER_OF_CONTRACT_LINES + 2));  //line 2 SProvider
            List<ServiceProvider> serviceProviderList = serviceProviderRepositoryInterface.getAllServiceProviders();
            ServiceProvider serviceProviderOfContract = null;
            for (ServiceProvider serviceProvider : serviceProviderList) {
                if (serviceProvider.getId().equals(serviceProviderId)) {
                    serviceProviderOfContract = serviceProvider;
                }
            }

            Integer householdId = Integer.parseInt(lines.get(i * NUMBER_OF_CONTRACT_LINES + 3));        //line 3 household
            List<Household> householdList = householdRepositoryInterface.getAllHouseholds();
            Household householdOfContract = null;

            for (Household house : householdList) {
                if (house.getId().equals(householdId)) {
                    householdOfContract = house;
                }
            }

            Contract newContract;

            if (contractType.equals("FIXED")) {

                String contractStartString = lines.get(i * NUMBER_OF_CONTRACT_LINES + 4);
                LocalDate contractStart = LocalDateUtility.convertStringToLocalDate(contractStartString);

                String contractEndString = lines.get(i * NUMBER_OF_CONTRACT_LINES + 5);
                LocalDate contractEnd = LocalDateUtility.convertStringToLocalDate(contractEndString);


                newContract = new FixedTermContract(contractId, contractType, serviceProviderOfContract, householdOfContract,
                        contractStart, contractEnd);
            } else {
                String contractStartString = lines.get(i * NUMBER_OF_CONTRACT_LINES + 4);
                LocalDate contractStart = LocalDateUtility.convertStringToLocalDate(contractStartString);

                newContract = new IndefiniteContract(contractId, contractType, serviceProviderOfContract, householdOfContract, contractStart);
            }

            contractList.add(newContract);
        }

        return contractList;
    }

    @Override
    public Optional<Contract> getContractById(Integer id) {
        return getAllContracts().stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    @Override
    public void saveNewcontract(Contract newContract) {
        List<Contract> allContractsList = getAllContracts();
        Integer highestId = allContractsList.stream()
                .map(s -> s.getId())
                .max((id1, id2) -> id1.compareTo(id2))
                .get();

        newContract.setId(highestId + 1);
        allContractsList.add(newContract);

        saveAllContractsToFile(allContractsList);
    }

    private static void saveAllContractsToFile(List<Contract> contractList) {
        Path serviceProviderFilePath = Path.of(CONTRACTS_FILE_NAME);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(serviceProviderFilePath.toFile(), false))) {
            //id, tip, serviceProvider, household, startDate, endDate
            for (Contract contract : contractList) {
                bufferedWriter.write(contract.getId().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(contract.getTip().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(contract.getPruzateljUsluge().getId().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(contract.getKucanstvo().getId().toString());
                bufferedWriter.newLine();
                if (contract instanceof FixedTermContract) {
                    bufferedWriter.write(LocalDateUtility.convertlocalDateToString(((FixedTermContract) contract).getContractStart()));
                    bufferedWriter.newLine();
                    bufferedWriter.write(LocalDateUtility.convertlocalDateToString(((FixedTermContract) contract).getContractEnd()));
                    bufferedWriter.newLine();
                } else if (contract instanceof IndefiniteContract) {
                    bufferedWriter.write(LocalDateUtility.convertlocalDateToString(((IndefiniteContract) contract).getContractStart()));
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Contract> updateContract(Contract updatedContract, Integer id) {
        List<Contract> contractsList = getAllContracts();

        Optional updatedContractOptional = Optional.empty();

        for (Contract contract : contractsList) {
            if (contract.getId().equals(id)) {
                contract.setTip(updatedContract.getTip());
                contract.setPruzateljUsluge(updatedContract.getPruzateljUsluge());
                contract.setKucanstvo(updatedContract.getKucanstvo());
                if (contract instanceof FixedTermContract fixed) {
                    fixed.setContractStart(((FixedTermContract)updatedContract).getContractStart());
                    fixed.setContractEnd(((FixedTermContract)updatedContract).getContractEnd());
                } else if (contract instanceof IndefiniteContract indefinite) {
                    indefinite.signContract(((IndefiniteContract) updatedContract).getContractStart());
                }
                updatedContractOptional = Optional.of(contract);
                break;
            }
        }

        if (updatedContractOptional.isPresent()) {
            saveAllContractsToFile(contractsList);
        }

        return Optional.empty();
    }

    @Override
    public void deleteContract(Integer id) {
        List<Contract> contractList = getAllContracts();

        List<Contract> contractRemovedList =
                contractList.stream()
                        .filter(f -> !f.getId().equals(id))
                        .collect(Collectors.toList());

        if (contractRemovedList.size() != contractList.size()) {
            saveAllContractsToFile(contractRemovedList);
        }
    }
}
