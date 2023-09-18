//package hr.apisit.energent.jdbcrepository;
//
//import hr.apisit.energent.domain.ServiceProvider;
//import hr.apisit.energent.repository.ServiceProviderRepositoryInterface;
////import hr.apisit.energent.rowmapper.ServiceProviderRowMapper;
//import lombok.AllArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@AllArgsConstructor
//public class JdbcServiceProviderRepository implements ServiceProviderRepositoryInterface {
//
//
//    private JdbcTemplate jdbcTemplate;
//
//
//    @Override
//    public List<ServiceProvider> getAllServiceProviders() {
//
////        List<ServiceProvider> servProviderlist =
////                jdbcTemplate.query("SELECT * FROM SERVICE_PROVIDER",
////                        new ServiceProviderRowMapper(jdbcTemplate));
////        return servProviderlist;
//        return null;
//    }
//
//    @Override
//    public ServiceProvider getServiceProviderById(Integer id) {
//
//////        ServiceProvider oneServiceProvider =
//////                jdbcTemplate.queryForObject("SELECT * FROM SERVICE_PROVIDER WHERE ID = ?",
//////                        new Object[] {id},new ServiceProviderRowMapper(jdbcTemplate));
////
////        ServiceProvider oneServiceProvider =
////                jdbcTemplate.queryForObject("SELECT * FROM SERVICE_PROVIDER WHERE ID = ?",
////                        new ServiceProviderRowMapper(jdbcTemplate), id);
////        return oneServiceProvider;
//        return null;
//    }
//
//    @Override
//    public void saveNewServiceProvide(ServiceProvider newServiceProvider) {
////        jdbcTemplate.update("INSERT INTO SERVICE_PROVIDER (NAME, ADDRESS_ID, SERVICE_TYPE_ID, PRICE) " +
////                        "VALUES(?,?,?,?)", newServiceProvider.getNaziv(), newServiceProvider.getAdresa().getId(),
////                newServiceProvider.getVrstaUsluge().getId(), newServiceProvider.getCijenaUsluge());
//    }
//
//    @Override
//    public ServiceProvider updateServiceProvider(ServiceProvider updatedServiceProvider, Integer id) {
////        jdbcTemplate.update("UPDATE SERVICE_PROVIDER SET NAME = ?, ADDRESS_ID = ?, SERVICE_TYPE_ID = ?, PRICE = ? WHERE ID = ?",
////                updatedServiceProvider.getNaziv(), updatedServiceProvider.getAdresa().getId(),
////                updatedServiceProvider.getVrstaUsluge().getId(), updatedServiceProvider.getCijenaUsluge(), id);
////
////
////        return getServiceProviderById(id);
//        return null;
//    }
//
//    @Override
//    public void deleteServiceProvider(Integer id) {
//        jdbcTemplate.update("DELETE FROM SERVICE_PROVIDER WHERE ID = ?",
//                id);
//    }
//}
