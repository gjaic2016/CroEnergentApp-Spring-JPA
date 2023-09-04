package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.ServiceProvider;

import java.util.List;

public interface SortedServiceProvidersByAdressReport {

    List<ServiceProvider> sortedServiceProvidersByAddress();

}
