package hr.apisit.energent.service;

import hr.apisit.energent.domain.Household;
import hr.apisit.energent.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface HouseholdService {

    List<Household> getAllHouseholds();

    Optional<Household> getHouseholdById(Integer id);

    void saveHousehold(Household newHousehold);

    Optional<Household> updateHousehold(Household updatedHousehold, Integer id);

//    void deleteHousehold(Integer id);

    void deleteHousehold(Household household);

}
