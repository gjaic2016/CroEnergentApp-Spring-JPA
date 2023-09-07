package hr.apisit.energent.repository;

import hr.apisit.energent.domain.ServiceProvider;

import java.util.List;
import java.util.Optional;

public interface ServiceProviderRepositoryInterface {

    List<ServiceProvider> getAllServiceProviders();

    ServiceProvider getServiceProviderById(Integer id);

    void saveNewServiceProvide(ServiceProvider newServiceProvider);

    ServiceProvider updateServiceProvider(ServiceProvider updatedServiceProvider, Integer id);

    void deleteServiceProvider(Integer id);
}
