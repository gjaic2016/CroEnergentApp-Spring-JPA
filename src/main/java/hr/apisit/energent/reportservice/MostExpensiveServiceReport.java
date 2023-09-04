package hr.apisit.energent.reportservice;

import hr.apisit.energent.domain.ServiceProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface MostExpensiveServiceReport {

    Map<String, BigDecimal> mostExpensiveService();
}
