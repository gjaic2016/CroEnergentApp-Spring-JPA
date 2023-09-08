package hr.apisit.energent.jdbcrepository;

import hr.apisit.energent.domain.Household;
import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.repository.HouseholdRepositoryInterface;
import hr.apisit.energent.rowmapper.HouseholdRowMapper;
import hr.apisit.energent.rowmapper.ServiceProviderRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JdbcHouseholdRepository implements HouseholdRepositoryInterface {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Household> getAllHouseholds() {
        List<Household> householdList =
                jdbcTemplate.query("SELECT * FROM HOUSEHOLD",
                        new HouseholdRowMapper(jdbcTemplate));
        return householdList;
    }

    @Override
    public Optional<Household> getHouseholdById(Integer id) {
        Household household =
                jdbcTemplate.queryForObject("SELECT * FROM HOUSEHOLD WHERE ID = ?",
                        new HouseholdRowMapper(jdbcTemplate), id);

        return Optional.of(household);
    }

    @Override
    public void saveNewHousehold(Household newHousehold) {
        jdbcTemplate.update("INSERT INTO HOUSEHOLD (ADDRESS) VALUES(?)", newHousehold.getAdresa());
    }

    @Override
    public Optional<Household> updateHousehold(Household updatedHousehold, Integer id) {
        jdbcTemplate.update("UPDATE HOUSEHOLD SET ADDRESS = ? WHERE ID = ?",
                updatedHousehold.getAdresa(), id);

        return Optional.empty();
    }

    @Override
    public void deleteHousehold(Integer id) {
        jdbcTemplate.update("DELETE FROM HOUSEHOLD WHERE ID = ?",
                id);
    }
}
