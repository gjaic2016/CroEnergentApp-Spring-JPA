package hr.apisit.energent.service;

import java.util.List;
import java.util.Optional;
import hr.apisit.energent.domain.ServiceType;

public interface ServiceTypeService {

    List<ServiceType> getAllServiceTypes();

    Optional<ServiceType> getServiceTypeById(Integer id);

    void saveServiceType(ServiceType newServiceType);

    ServiceType updateServiceType(ServiceType updatedServiceType, Integer id);

    void deleteServiceType(Integer id);

}
