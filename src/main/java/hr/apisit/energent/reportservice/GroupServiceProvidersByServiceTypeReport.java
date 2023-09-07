package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.domain.ServiceType2;

import java.util.List;
import java.util.Map;

public interface GroupServiceProvidersByServiceTypeReport {

    Map<ServiceType2, List<ServiceProvider>> getGroupedSProvidersByServiceType();

}
