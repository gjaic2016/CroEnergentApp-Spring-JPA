package hr.apisit.energent.service;

import hr.apisit.energent.exception.EntityNotFoundException;
import hr.apisit.energent.jpaRepository.ServiceTypeRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import hr.apisit.energent.domain.ServiceType;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceTypeImpl implements ServiceTypeService {

    private ServiceTypeRepositoryJpa serviceTypeRepositoryJpa;

    @Override
    public List<ServiceType> getAllServiceTypes() {
        return serviceTypeRepositoryJpa.findAll();
    }

    @Override
    public Optional<ServiceType> getServiceTypeById(Integer id) {
        return serviceTypeRepositoryJpa.findById(id);
    }

    @Override
    public void saveServiceType(ServiceType newServiceType) {
        serviceTypeRepositoryJpa.save(newServiceType);
    }

    @Override
    public ServiceType updateServiceType(ServiceType serviceTypeToUpdate, Integer originalServiceTypeId) {
        Optional<ServiceType> modifiedServiceTypeOptional = serviceTypeRepositoryJpa.findById(originalServiceTypeId);

        if(modifiedServiceTypeOptional.isPresent()) {
            ServiceType modifiedServiceType = modifiedServiceTypeOptional.get();

            modifiedServiceType.setNaziv(serviceTypeToUpdate.getNaziv());

            ServiceType newUpdatedServiceType = serviceTypeRepositoryJpa.save(modifiedServiceType);

            return newUpdatedServiceType;
        }
        else {
            throw new EntityNotFoundException("There is no Service Type object for ID = '" + originalServiceTypeId + "'");
        }
    }

    @Override
    public void deleteServiceType(Integer id) {
        serviceTypeRepositoryJpa.delete(getServiceTypeById(id).get());
    }


}
