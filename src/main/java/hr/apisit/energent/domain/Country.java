package hr.apisit.energent.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    private Integer id;
    private String name;

    public Country(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
