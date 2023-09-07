package hr.apisit.energent.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private Integer id;

    private String address;

    private City city;

    public Address(Integer id, String address, City city) {
        this.id = id;
        this.address = address;
        this.city = city;
    }


}
