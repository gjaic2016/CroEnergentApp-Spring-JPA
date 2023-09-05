package hr.apisit.energent.repository;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.rowmapper.ServiceProviderRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JdbcServiceProviderRepository implements ServiceProviderRepositoryInterface{


    private JdbcTemplate jdbcTemplate;


    @Override
    public List<ServiceProvider> getAllServiceProviders() {

        List<ServiceProvider> servProviderlist =
                jdbcTemplate.query("SELECT * FROM SERVICE_PROVIDER", new ServiceProviderRowMapper());

        return servProviderlist;
    }

    @Override
    public Optional<ServiceProvider> getServiceProviderById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void saveNewServiceProvide(ServiceProvider newServiceProvider) {

    }

    @Override
    public Optional<ServiceProvider> updateServiceProvider(ServiceProvider updatedServiceProvider, Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteServiceProvider(Integer id) {

    }
}
