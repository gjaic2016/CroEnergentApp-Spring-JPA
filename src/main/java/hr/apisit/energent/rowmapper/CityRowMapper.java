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
//public class CityRowMapper implements RowMapper<City> {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        Integer id = rs.getInt("ID");
//        String cityZip = rs.getString("CITY_ZIP");
//        String cityName = rs.getString("CITY_NAME");
//        Integer countryId = rs.getInt("COUNTRY_ID");
//
////        Country country = new Country(25, "Croatia");
//
//        Country country = jdbcTemplate.queryForObject("SELECT * FROM COUNTRY WHERE ID = ?",
//                new CountryRowMapper(), countryId);
//
////        City city = new City(id, cityZip, cityName, country);
////
////        return city;
//
//        return null;
//    }
//}
