package hr.apisit.energent.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Household implements Comparable<Household> {

    private Integer id;
    private String adresa;
    private Owner vlasnik;

    public Household(Integer id, String adresa, Owner vlasnik) {
        this.id = id;
        this.adresa = adresa;
        this.vlasnik = vlasnik;
    }

    @Override
    public int compareTo(Household o) {
        return this.getVlasnik().getPrezime().compareTo(o.getVlasnik().getPrezime());
    }

}
