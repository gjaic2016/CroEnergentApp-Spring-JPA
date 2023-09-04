package hr.apisit.energent.service;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.repository.ServiceProviderRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceProviderServiceImpl implements ServiceProviderService{

    private ServiceProviderRepositoryInterface serviceProviderRepositoryInterface;

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepositoryInterface.getAllServiceProviders();
    }

    @Override
    public Optional<ServiceProvider> getServiceProviderById(Integer id) {
        return serviceProviderRepositoryInterface.getServiceProviderById(id);
    }

    @Override
    public void saveNewServiceProvider(ServiceProvider newServiceProvider) {
        serviceProviderRepositoryInterface.saveNewServiceProvide(newServiceProvider);
    }

    @Override
    public Optional<ServiceProvider> updateServiceProvider(ServiceProvider updatedServiceProvider, Integer id) {
         return serviceProviderRepositoryInterface.updateServiceProvider(updatedServiceProvider,id);
    }

    @Override
    public void deleteServiceProvider(Integer id) {
        serviceProviderRepositoryInterface.deleteServiceProvider(id);
    }


}
