//package hr.apisit.energent.rowmapper;
//
//import hr.apisit.energent.domain.City;
//import hr.apisit.energent.domain.Country;
//import lombok.AllArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@AllArgsConstructor
//public class CountryRowMapper implements RowMapper<Country> {
//
//    @Override
//    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        Integer id = rs.getInt("ID");
//        String name = rs.getString("NAME");
//
//        Country country = new Country(id, name);
//
//        return country;
//    }
//}
