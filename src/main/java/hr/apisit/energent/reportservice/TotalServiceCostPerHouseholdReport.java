package hr.apisit.energent.reportservice;

import java.math.BigDecimal;
import java.util.Map;

public interface TotalServiceCostPerHouseholdReport {

    public Map<String, BigDecimal> totalServiceCostPerHousehold();
}
