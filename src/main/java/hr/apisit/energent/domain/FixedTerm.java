package hr.apisit.energent.domain;

import java.time.LocalDate;

public interface FixedTerm{

    void setContractStart(LocalDate startDate);

    void setContractEnd(LocalDate endDate);

}
