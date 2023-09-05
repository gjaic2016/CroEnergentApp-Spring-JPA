package hr.apisit.energent.rowmapper;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.domain.ServiceType;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.security.Provider;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServiceProviderRowMapper implements RowMapper<ServiceProvider> {

    @Override
    public ServiceProvider mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("ID");
        String naziv = rs.getString("NAME");
        Integer adresa = rs.getInt("ADDRESS_ID");
        Integer vrstaUsluge = rs.getInt("SERVICE_TYPE_ID");
        BigDecimal cijenaUsluge = rs.getBigDecimal("PRICE");

        ServiceProvider serviceProvider = new ServiceProvider(id, naziv, adresa, vrstaUsluge, cijenaUsluge);

        return serviceProvider;
    }
}
