//package hr.apisit.energent.rowmapper;
//
//import hr.apisit.energent.domain.Address;
//import hr.apisit.energent.domain.Household;
//
//import hr.apisit.energent.domain.Owner;
//import lombok.AllArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@AllArgsConstructor
//public class HouseholdRowMapper implements RowMapper<Household> {
//
//    private JdbcTemplate jdbcTemplate;
//    final static String HOUSEHOLD_SQL = "SELECT *\n" +
//            "FROM household AS h\n" +
//            "JOIN household_owner AS ho ON ho.HOUSEHOLD_ID = h.id\n" +
//            "JOIN owner AS o ON o.ID = ho.OWNER_ID\n" +
//            "WHERE h.ID = ?;";
//    @Override
//    public Household mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        Integer id = rs.getInt("ID");
//        String naziv = rs.getString("ADDRESS");
//
//        List<Owner> owner = jdbcTemplate.query(HOUSEHOLD_SQL,
//                new OwnerRowMapper(), id);
//
//        Household household = new Household(id, naziv,owner);
//
//        return household;
//    }
//}
