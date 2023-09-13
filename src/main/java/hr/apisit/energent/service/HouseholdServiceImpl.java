package hr.apisit.energent.service;

import hr.apisit.energent.domain.Household;
import hr.apisit.energent.jpaRepository.HouseholdRepositoryJpa;
import hr.apisit.energent.repository.HouseholdRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseholdServiceImpl implements HouseholdService{


  private HouseholdRepositoryJpa householdRepositoryJpa;


//    private HouseholdRepositoryInterface householdRepositoryInterface;

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepositoryJpa.findAll();
//        return householdRepositoryInterface.getAllHouseholds();
    }

    @Override
    public Optional<Household> getHouseholdById(Integer id) {
        return householdRepositoryJpa.findById(id);
//        return householdRepositoryInterface.getHouseholdById(id);
    }

    @Override
    public void saveHousehold(Household newHousehold) {
        householdRepositoryJpa.save(newHousehold);
//        householdRepositoryInterface.saveNewHousehold(newHousehold);
    }

    @Override
    public Optional<Household> updateHousehold(Household updatedHousehold, Integer id) {
        return Optional.of(householdRepositoryJpa.save(updatedHousehold));
//        return householdRepositoryInterface.updateHousehold(updatedHousehold, id);
    }

    @Override
    public void deleteHousehold(Household household) {
        householdRepositoryJpa.delete(household);
//        householdRepositoryInterface.deleteHousehold(id);
    }
}
