package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@JsonTypeName("INDEFINITE")
public class IndefiniteContract extends Contract implements Indefinite{


    private LocalDate contractStart;

    public IndefiniteContract() {
    }

    public IndefiniteContract(Integer id,String tip, ServiceProvider pruzateljUsluge, Household kucanstvo, LocalDate contractStart) {
        super(id, tip, pruzateljUsluge, kucanstvo);
        this.contractStart = contractStart;
    }

    @Override
    public void signContract(LocalDate startDate) {
        this.contractStart = startDate;
    }

    public LocalDate getContractStart() {
        return contractStart;
    }

    @Override
    public String toString() {
        return "IndefiniteContract{" +
                "contractStart=" + contractStart +
                '}';
    }
}
