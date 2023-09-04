package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.domain.ServiceType;

import java.util.List;
import java.util.Map;

public interface GroupServiceProvidersByServiceTypeReport {

    Map<ServiceType, List<ServiceProvider>> getGroupedSProvidersByServiceType();

}
