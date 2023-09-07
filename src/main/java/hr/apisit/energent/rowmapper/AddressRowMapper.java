package hr.apisit.energent.rowmapper;

import hr.apisit.energent.domain.Address;
import hr.apisit.energent.domain.City;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class AddressRowMapper implements RowMapper<Address> {

    private JdbcTemplate jdbcTemplate;
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("ID");
        String addressName = rs.getString("ADDRESS");
        Integer cityId = rs.getInt("CITY_ID");

        City city = jdbcTemplate.queryForObject("SELECT * FROM CITY WHERE ID = ?",
                new CityRowMapper(jdbcTemplate), cityId);

        Address address = new Address(id,addressName, city );

        return address;
    }
}
