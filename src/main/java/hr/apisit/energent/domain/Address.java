package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="address")
    private String address;

    @ManyToOne
    private City city;

    @OneToOne(mappedBy = "adresa")
    @JsonIgnore
    private ServiceProvider provider;

}
