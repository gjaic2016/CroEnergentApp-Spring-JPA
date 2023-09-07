package hr.apisit.energent.rowmapper;

import hr.apisit.energent.domain.ServiceType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeRowMapper implements RowMapper<ServiceType> {
    @Override
    public ServiceType mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("ID");
        String name = rs.getString("NAME");

        ServiceType serviceType = new ServiceType(id, name);

        return serviceType;
    }
}
