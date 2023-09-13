package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

//@Getter
//@Setter
@Entity
@Table(name="CITY")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="city_zip")
    private String city_zip;

    @Column(name="city_name")
    private String city_name;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "country_id")
    private Country country;

    public City(Integer id, String city_zip, String city_name, Country country) {
        this.id = id;
        this.city_zip = city_zip;
        this.city_name = city_name;
        this.country = country;
    }

    public City() {

    }

//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getId() {
//        return id;
//    }
}
