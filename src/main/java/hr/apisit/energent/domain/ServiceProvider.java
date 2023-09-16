package hr.apisit.energent.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


//@Getter
//@Setter
@Entity
@Table(name = "SERVICE_PROVIDER")
@Data
@NoArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String naziv;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address adresa;

//    @OneToOne
//    @JoinColumn(name = "service_type_id")
//    private ServiceType vrstaUsluge;

//    @Column(name = "PRICE")
//    private BigDecimal cijenaUsluge;

    public ServiceProvider(Integer id, String naziv, Address adresa) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
    }
}
