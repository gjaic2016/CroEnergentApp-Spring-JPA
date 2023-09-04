package hr.apisit.energent.reportservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.repository.ServiceProviderRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@AllArgsConstructor
public class MostExpensiveServiceReportImpl implements MostExpensiveServiceReport{

    private ServiceProviderRepositoryInterface serviceProviderRepositoryInterface;

    @Override
    public Map<String, BigDecimal> mostExpensiveService() {

        List<ServiceProvider> serviceProviderList =  serviceProviderRepositoryInterface.getAllServiceProviders();

        Map<String, List<ServiceProvider>> mapOfCategory = new HashMap<>();

        for (ServiceProvider serviceProvider : serviceProviderList) {
            if (mapOfCategory.containsKey(serviceProvider.getNaziv())) {
                List<ServiceProvider> noviServiceProviderList = mapOfCategory.get(serviceProvider.getNaziv());
                noviServiceProviderList.add(serviceProvider);
                mapOfCategory.put(serviceProvider.getNaziv(), noviServiceProviderList);
            } else {
                List<ServiceProvider> noviServiceProviderList = new ArrayList<>();
                noviServiceProviderList.add(serviceProvider);
                mapOfCategory.put(serviceProvider.getNaziv(), noviServiceProviderList);
            }
        }

        Map<String, BigDecimal> sortedMapOfCategory = new TreeMap<>();

        for (String key : mapOfCategory.keySet()) {
            sortedMapOfCategory.put(key,mapOfCategory.get(key)
                    .stream()
                    .max(Comparator.comparing(s -> s.getCijenaUsluge()))
                    .get().getCijenaUsluge());
        }

        return sortedMapOfCategory;

    }
}
