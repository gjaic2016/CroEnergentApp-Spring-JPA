package hr.apisit.energent.repository;

import hr.apisit.energent.domain.Contract;
import hr.apisit.energent.domain.Household;
import hr.apisit.energent.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface HouseholdRepositoryInterface {


    List<Household> getAllHouseholds();

    Optional<Household> getHouseholdById(Integer id);

    void saveNewHousehold(Household newHousehold);

    Optional<Household> updateHousehold(Household updatedHousehold, Integer id);

    void deleteHousehold(Integer id);

}
