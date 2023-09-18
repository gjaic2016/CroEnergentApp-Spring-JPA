package hr.apisit.energent.jpaRepository;

import hr.apisit.energent.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceProviderRepositoryJpa extends JpaRepository<ServiceProvider,Integer> {

    @Query(value = """
            SELECT sp.* FROM service_provider sp
            JOIN service s ON s.SERVICE_PROVIDER_ID = sp.ID
            JOIN contract c ON c.SERVICE_ID = s.ID
            WHERE c.END_DATE IS NULL;
                """, nativeQuery = true)
    List<ServiceProvider> getContractOfServiceProviderWithEndDateNull();
}
