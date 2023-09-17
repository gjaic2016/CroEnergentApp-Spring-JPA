package hr.apisit.energent.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="SERVICE")
@Data
@NoArgsConstructor
public class ServiceSP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @Column(name="price")
    private BigDecimal price;

    //List<Contract> contracts;

    public ServiceSP(Integer id, ServiceProvider serviceProvider, ServiceType serviceType, BigDecimal price) {
        this.id = id;
        this.serviceProvider = serviceProvider;
        this.serviceType = serviceType;
        this.price = price;
    }
}
