package hr.apisit.energent.service;

import hr.apisit.energent.domain.ServiceProvider;

import java.util.List;
import java.util.Optional;


public interface ServiceProviderService {

    List<ServiceProvider> getAllServiceProviders();

    Optional<ServiceProvider> getServiceProviderById(Integer id);

    void saveNewServiceProvider(ServiceProvider newServiceProvider);

    Optional<ServiceProvider> updateServiceProvider(ServiceProvider updatedServiceProvider, Integer id);

    void deleteServiceProvider(Integer id);
}
