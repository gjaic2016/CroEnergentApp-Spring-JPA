package hr.apisit.energent.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Household  {

    private Integer id;
    private String adresa;
    private List<Owner> vlasnik;

    public Household(Integer id, String adresa, List<Owner> vlasnik) {
        this.id = id;
        this.adresa = adresa;
        this.vlasnik = vlasnik;
    }


}
