package hr.apisit.energent.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SERVICE_PROVIDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String naziv;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address adresa;

}
