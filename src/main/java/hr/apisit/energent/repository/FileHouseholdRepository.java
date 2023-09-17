//package hr.apisit.energent.repository;
//
//import hr.apisit.energent.domain.*;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
////@Repository
////@AllArgsConstructor
//public class FileHouseholdRepository implements HouseholdRepositoryInterface{
//
//    public static final Integer NUMBER_OF_HOUSEHOLD_LINES = 3;
//
//    public static final String HOUSEHOLD_FILE_NAME = "dat/households.txt";
//    public static final String HOUSEHOLD_SAVE_TEST_FILE = "dat/testHousehold.txt";
//
//    private OwnerRepositoryInterface ownerRepositoryInterface;
//
//    @Override
//    public List<Household> getAllHouseholds() {
//        List<Household> householdList = new ArrayList<>();
//
//        Path stageFilePath = Path.of(HOUSEHOLD_FILE_NAME);
//
//        List<String> lines;
//        try {
//            lines = Files.readAllLines(stageFilePath);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
////        for (int i = 0; i < lines.size() / NUMBER_OF_HOUSEHOLD_LINES; i++) {
////
////            Integer householdId = Integer.parseInt(lines.get(i * NUMBER_OF_HOUSEHOLD_LINES));           //id
////
////            String householdAddress = lines.get(i * NUMBER_OF_HOUSEHOLD_LINES + 1);                     //address
////
////            Integer householdOwnerId = Integer.parseInt(lines.get(i * NUMBER_OF_HOUSEHOLD_LINES + 2));  //ownerid
////            Optional<Owner> householdOwner = ownerRepositoryInterface.getOwnerById(householdOwnerId);
////
////            Owner newHouseholdOwner = null;
////            if(householdOwner.isPresent()){
////                newHouseholdOwner = householdOwner.get();
////
////            }
////
////            Household newHousehold = new Household(householdId, householdAddress, newHouseholdOwner);
////            householdList.add(newHousehold);
////        }
//        return householdList;
//    }
//
//    @Override
//    public Optional<Household> getHouseholdById(Integer id) {
//        return getAllHouseholds().stream().filter(f -> f.getId().equals(id)).findFirst();
//    }
//
//    @Override
//    public void saveNewHousehold(Household newHousehold) {
//        List<Household> allHouseholdsList = getAllHouseholds();
//        Integer highestId = allHouseholdsList.stream()
//                .map(s -> s.getId())
//                .max((id1, id2) -> id1.compareTo(id2))
//                .get();
//
//        newHousehold.setId(highestId + 1);
//        allHouseholdsList.add(newHousehold);
//
//        saveAllHouseholdsToFile(allHouseholdsList);
//    }
//
//    private static void saveAllHouseholdsToFile(List<Household> householdsList) {
//        Path serviceProviderFilePath = Path.of(HOUSEHOLD_FILE_NAME);
//
////        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(serviceProviderFilePath.toFile(), false))) {
////            //id, adresa-string, vlasnik.id
////            for (Household household : householdsList) {
////                bufferedWriter.write(household.getId().toString());
////                bufferedWriter.newLine();
////                bufferedWriter.write(household.getAdresa().toString());
////                bufferedWriter.newLine();
////                bufferedWriter.write(household.getVlasnik().getId().toString());
////                bufferedWriter.newLine();
////            }
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//    }
//
//    @Override
//    public Optional<Household> updateHousehold(Household updatedHousehold, Integer id) {
//        List<Household> householdList = getAllHouseholds();
//
//        Optional updatedHouseholdOptional = Optional.empty();
//
//        for(Household household : householdList) {
//            if(household.getId().equals(id)) {
//                household.setAdresa(updatedHousehold.getAdresa());
//                household.setVlasnik(updatedHousehold.getVlasnik());
//
//                updatedHouseholdOptional = Optional.of(household);
//                break;
//            }
//        }
//
//        if(updatedHouseholdOptional.isPresent()) {
//            saveAllHouseholdsToFile(householdList);
//        }
//
//        return updatedHouseholdOptional;
//    }
//
//    @Override
//    public void deleteHousehold(Integer id) {
//        List<Household> householdsList = getAllHouseholds();
//
//        List<Household> householdRemovedList =
//                householdsList.stream()
//                        .filter( f -> !f.getId().equals(id))
//                        .collect(Collectors.toList());
//
//        if(householdRemovedList.size() != householdsList.size()){
//            saveAllHouseholdsToFile(householdRemovedList);
//        }
//    }
//}
