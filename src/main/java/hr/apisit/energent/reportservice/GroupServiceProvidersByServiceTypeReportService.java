package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.domain.ServiceType;
import hr.apisit.energent.repository.ServiceProviderRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class GroupServiceProvidersByServiceTypeReportService implements GroupServiceProvidersByServiceTypeReport {

    private ServiceProviderRepositoryInterface serviceProviderRepositoryInterface;

    @Override
    public Map<ServiceType, List<ServiceProvider>> getGroupedSProvidersByServiceType() {

        List<ServiceProvider> serviceProviderList = serviceProviderRepositoryInterface.getAllServiceProviders();

        Map<ServiceType, List<ServiceProvider>> mapaUslugaPoTipu = new HashMap<>();

        List<ServiceProvider> groupedProviders;

        for (ServiceType type : ServiceType.values()) {
            groupedProviders = new ArrayList<>();
            for (ServiceProvider provider : serviceProviderList) {
                if (type.equals(provider.getVrstaUsluge())) {
                    groupedProviders.add(provider);
                }
            }
            mapaUslugaPoTipu.put(type, groupedProviders);
        }
        mapaUslugaPoTipu.entrySet().stream()
                .sorted(Map.Entry.comparingByKey());
        return mapaUslugaPoTipu;
    }

}

