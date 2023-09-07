package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.repository.ServiceProviderRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SortedServiceProvidersByAddressImpl implements SortedServiceProvidersByAdressReport{

    private ServiceProviderRepositoryInterface serviceProviderRepositoryInterface;


    @Override
    public List<ServiceProvider> sortedServiceProvidersByAddress() {

        List<ServiceProvider> serviceProviderList =  serviceProviderRepositoryInterface.getAllServiceProviders();

        Set<String> nameSet = new HashSet<>();

        List<ServiceProvider> providersDistinctByName = serviceProviderList.stream()
                .filter(e -> nameSet.add(e.getNaziv()))
                .collect(Collectors.toList());
//        providersDistinctByName.sort(Comparator.comparing(ServiceProvider::getAdresa));

        return providersDistinctByName;
    }
}
