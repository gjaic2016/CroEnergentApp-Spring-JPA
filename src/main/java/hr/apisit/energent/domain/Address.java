package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

//@Getter
//@Setter
@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="address")
//    @JoinColumn(name = "city_id")
    private String address;

    @ManyToOne
    private City city;

    @OneToOne(mappedBy = "adresa")
    @JsonIgnore
    private ServiceProvider provider;

    public Address(Integer id, String address, City city) {
        this.id = id;
        this.address = address;
        this.city = city;
    }
}
