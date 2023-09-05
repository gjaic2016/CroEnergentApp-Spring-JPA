package hr.apisit.energent.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {

    private Integer id;
    private String city_zip;
    private String city_name;
    private Integer country;

    public City(Integer id, String city_zip, String city_name, Integer country) {
        this.id = id;
        this.city_zip = city_zip;
        this.city_name = city_name;
        this.country = country;
    }
}
