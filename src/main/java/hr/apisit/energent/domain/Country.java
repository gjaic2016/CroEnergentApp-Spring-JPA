package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Getter
//@Setter
@Entity
@Table(name="COUNTRY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

//    @JsonIgnoreProperties("country")
//    @JsonIgnore

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<City> cities;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="city_id")
//    private List<City> cities;

}
