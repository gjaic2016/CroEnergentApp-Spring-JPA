package hr.apisit.energent.repository;

import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.utility.LocalDateUtility;
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

//@Repository
public class FileOwnerRepository implements OwnerRepositoryInterface{

    public static final Integer NUMBER_OF_OWNER_DATA_LINES = 5;

    public static final String OWNER_FILE_NAME = "dat/owners.txt";
    public static final String OWNER_FILE_SAVE = "dat/testOwner.txt";

    @Override
    public List<Owner> getAllOwners() {
        List<Owner> ownerList = new ArrayList<>();

        Path stageFilePath = Path.of(OWNER_FILE_NAME);

        List<String> lines;

        try {
            lines = Files.readAllLines(stageFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < lines.size() / NUMBER_OF_OWNER_DATA_LINES; i++) {

            Integer ownerId = Integer.parseInt(lines.get(i * NUMBER_OF_OWNER_DATA_LINES));
            String ownerIme = lines.get(i * NUMBER_OF_OWNER_DATA_LINES + 1);
            String ownerPrezime = lines.get(i * NUMBER_OF_OWNER_DATA_LINES + 2);
            String ownerDatumRodenjaString = lines.get(i * NUMBER_OF_OWNER_DATA_LINES + 3);

            LocalDate ownerDatumRodenja =
                    LocalDateUtility.convertStringToLocalDate(
                            ownerDatumRodenjaString);

            String ownerOib = lines.get(i * NUMBER_OF_OWNER_DATA_LINES + 4);

            Owner newOwner = new Owner(ownerId, ownerIme, ownerPrezime, ownerDatumRodenja, ownerOib);
            ownerList.add(newOwner);
        }
        return ownerList;
    }

    @Override
    public Optional<Owner> getOwnerById(Integer id) {
        List<Owner> ownersList =  getAllOwners();
        return ownersList.stream().filter(f -> f.getId().equals(id)).findAny();
    }

    @Override
    public void saveNewOwner(Owner newOwner) {
        List<Owner> allOwnersList = getAllOwners();
        Integer highestId = allOwnersList.stream()
                .map(s -> s.getId())
                .max((id1, id2) -> id1.compareTo(id2))
                .get();

        newOwner.setId(highestId + 1);
        allOwnersList.add(newOwner);

        saveAllOwnersToFile(allOwnersList);

    }

    private static void saveAllOwnersToFile(List<Owner> ownersList) {
        Path serviceProviderFilePath = Path.of(OWNER_FILE_NAME);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(serviceProviderFilePath.toFile(), false))) {

            for (Owner owner : ownersList) {
                bufferedWriter.write(owner.getId().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(owner.getIme().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(owner.getPrezime().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(LocalDateUtility.convertlocalDateToString(owner.getDatumRodenja()));
                bufferedWriter.newLine();
                bufferedWriter.write(owner.getOib().toString());
                bufferedWriter.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Owner> updateOwner(Owner updatedOwner, Integer id) {
        List<Owner> ownersList = getAllOwners();

        Optional updatedOwnerOptional = Optional.empty();

        for(Owner owner : ownersList) {
            if(owner.getId().equals(id)) {
                owner.setIme(updatedOwner.getIme());
                owner.setPrezime(updatedOwner.getPrezime());
                owner.setDatumRodenja(updatedOwner.getDatumRodenja());
                owner.setOib(updatedOwner.getOib());

                updatedOwnerOptional = Optional.of(owner);
                break;
            }
        }

        if(updatedOwnerOptional.isPresent()) {
            saveAllOwnersToFile(ownersList);
        }

        return updatedOwnerOptional;
    }

    @Override
    public void deleteOwner(Integer id) {
        List<Owner> ownersList = getAllOwners();

        List<Owner> ownerRemovedList =
                ownersList.stream()
                        .filter( f -> !f.getId().equals(id))
                        .collect(Collectors.toList());

        if(ownerRemovedList.size() != ownersList.size()){
            saveAllOwnersToFile(ownerRemovedList);
        }
    }
}
