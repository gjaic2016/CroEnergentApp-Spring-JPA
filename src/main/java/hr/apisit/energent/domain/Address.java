package hr.apisit.energent.domain;

import jakarta.persistence.*;
import lombok.*;

//@Getter
//@Setter
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
//    @JoinColumn(name = "city_id")
    private String address;

    @ManyToOne
    private City city;

}
