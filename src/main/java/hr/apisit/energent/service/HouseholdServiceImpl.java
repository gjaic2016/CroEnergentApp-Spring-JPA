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

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepositoryJpa.findAll();
    }

    @Override
    public Optional<Household> getHouseholdById(Integer id) {
        return householdRepositoryJpa.findById(id);
    }

    @Override
    public void saveHousehold(Household newHousehold) {
        householdRepositoryJpa.save(newHousehold);
    }

    @Override
    public Optional<Household> updateHousehold(Household updatedHousehold, Integer id) {
        //????
        return Optional.of(householdRepositoryJpa.save(updatedHousehold));
    }

    @Override
    public void deleteHousehold(Household household) {
        householdRepositoryJpa.delete(household);
    }
}
