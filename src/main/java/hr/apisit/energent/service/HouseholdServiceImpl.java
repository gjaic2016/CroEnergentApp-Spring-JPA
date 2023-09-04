package hr.apisit.energent.service;

import hr.apisit.energent.domain.Household;
import hr.apisit.energent.repository.HouseholdRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseholdServiceImpl implements HouseholdService{

    private HouseholdRepositoryInterface householdRepositoryInterface;

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepositoryInterface.getAllHouseholds();
    }

    @Override
    public Optional<Household> getHouseholdById(Integer id) {
        return householdRepositoryInterface.getHouseholdById(id);
    }

    @Override
    public void saveHousehold(Household newHousehold) {
        householdRepositoryInterface.saveNewHousehold(newHousehold);
    }

    @Override
    public Optional<Household> updateHousehold(Household updatedHousehold, Integer id) {
        return householdRepositoryInterface.updateHousehold(updatedHousehold, id);
    }

    @Override
    public void deleteHousehold(Integer id) {
        householdRepositoryInterface.deleteHousehold(id);
    }
}
