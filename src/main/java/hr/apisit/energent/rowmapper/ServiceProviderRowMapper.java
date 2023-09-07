package hr.apisit.energent.rowmapper;

import hr.apisit.energent.domain.Address;
import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.domain.ServiceType;
import hr.apisit.energent.domain.ServiceType2;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class ServiceProviderRowMapper implements RowMapper<ServiceProvider> {
        private JdbcTemplate jdbcTemplate;

    @Override
    public ServiceProvider mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("ID");
        String naziv = rs.getString("NAME");
        Integer adresaId = rs.getInt("ADDRESS_ID");
        Integer vrstaUslugeId = rs.getInt("SERVICE_TYPE_ID");
        BigDecimal cijenaUsluge = rs.getBigDecimal("PRICE");

        Address adresa = jdbcTemplate.queryForObject("SELECT * FROM ADDRESS WHERE ID = ?",
                new AddressRowMapper(jdbcTemplate), adresaId);

        ServiceType vrstaUsluge = jdbcTemplate.queryForObject("SELECT * FROM SERVICE_TYPE WHERE ID = ?",
                new ServiceTypeRowMapper(), vrstaUslugeId);

        ServiceProvider serviceProvider = new ServiceProvider(id, naziv, adresa, vrstaUsluge, cijenaUsluge);

        return serviceProvider;
    }
}
