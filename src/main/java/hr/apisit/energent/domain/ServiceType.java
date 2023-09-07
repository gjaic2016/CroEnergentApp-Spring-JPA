package hr.apisit.energent.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceType {

    private Integer id;
    private String naziv;

    public ServiceType(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }
}
