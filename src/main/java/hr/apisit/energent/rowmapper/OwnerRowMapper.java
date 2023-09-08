package hr.apisit.energent.rowmapper;

import hr.apisit.energent.domain.Owner;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@AllArgsConstructor
public class OwnerRowMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("ID");
        String ime = rs.getString("IME");
        String prezime = rs.getString("PREZIME");
        Date datumRodenja = rs.getDate("DATUM_RODENJA");
        LocalDate localDatRod = datumRodenja.toLocalDate();
        String oib = rs.getString("OIB");

        Owner owner = new Owner(id,ime, prezime, localDatRod, oib);
        return owner;
    }
}
