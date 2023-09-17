package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="CONTRACT")
@Data
@ToString
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CONTRACT_TYPE_ID")
    private ContractType contractType;

    @ManyToOne
    @JoinColumn(name = "HOUSEHOLD_ID")
    private Household household;

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private ServiceSP serviceSP;

    @Column(name="start_date")
    private LocalDate start_date;

    @Column(name="end_date")
    private LocalDate end_date;


    public Contract(Integer id, ContractType contractType, Household household, ServiceSP serviceSP, LocalDate start_date, LocalDate end_date) {
        this.id = id;
        this.contractType = contractType;
        this.household = household;
        this.serviceSP = serviceSP;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
