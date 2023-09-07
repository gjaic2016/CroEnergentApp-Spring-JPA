package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.domain.ServiceType2;
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
    public Map<ServiceType2, List<ServiceProvider>> getGroupedSProvidersByServiceType() {

        List<ServiceProvider> serviceProviderList = serviceProviderRepositoryInterface.getAllServiceProviders();

        Map<ServiceType2, List<ServiceProvider>> mapaUslugaPoTipu = new HashMap<>();

        List<ServiceProvider> groupedProviders;

        for (ServiceType2 type : ServiceType2.values()) {
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

