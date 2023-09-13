package hr.apisit.energent.jdbcrepository;

import hr.apisit.energent.domain.Household;
import hr.apisit.energent.domain.Owner;
import hr.apisit.energent.repository.OwnerRepositoryInterface;
import hr.apisit.energent.rowmapper.HouseholdRowMapper;
import hr.apisit.energent.rowmapper.OwnerRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JdbcOwnerRepository implements OwnerRepositoryInterface {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Owner> getAllOwners() {
        List<Owner> ownerList =
                jdbcTemplate.query("SELECT * FROM OWNER",
                        new OwnerRowMapper());
        return ownerList;
    }

    @Override
    public Optional<Owner> getOwnerById(Integer id) {
        Owner owner =
                jdbcTemplate.queryForObject("SELECT * FROM OWNER WHERE ID = ?",
                        new OwnerRowMapper(), id);


        return Optional.of(owner);
    }

    @Override
    public void saveNewOwner(Owner newOwner) {
        jdbcTemplate.update("INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES(?,?,?,?)",
                newOwner.getIme(), newOwner.getPrezime(), newOwner.getDatumRodenja(),newOwner.getOib());
    }

    @Override
    public Optional<Owner> updateOwner(Owner updatedOwner, Integer id) {
        jdbcTemplate.update("UPDATE OWNER SET IME = ?, PREZIME = ?, " +
                        "DATUM_RODENJA = ?, OIB = ? WHERE ID = ?",
                updatedOwner.getIme(),updatedOwner.getPrezime(),
                updatedOwner.getDatumRodenja(), updatedOwner.getOib(), id);

        Optional<Owner> newUpdatedOwner = getOwnerById(id);
        return newUpdatedOwner;
    }

    @Override
    public void deleteOwner(Integer id) {
        jdbcTemplate.update("DELETE FROM OWNER WHERE ID = ?",
                id);
    }
}
