package hr.apisit.energent.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private Integer id;

    private String address;

    private Integer city;

    public Address(Integer id, String address, Integer city) {
        this.id = id;
        this.address = address;
        this.city = city;
    }


}
