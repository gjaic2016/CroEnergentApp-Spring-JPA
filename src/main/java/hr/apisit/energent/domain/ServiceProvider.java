package hr.apisit.energent.domain;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class ServiceProvider {

    private Integer id;
    private String naziv;
    private String adresa;
    private ServiceType vrstaUsluge;
    private BigDecimal cijenaUsluge;

    public ServiceProvider(Integer id, String naziv, String adresa, ServiceType vrstaUsluge, BigDecimal cijenaUsluge) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.vrstaUsluge = vrstaUsluge;
        this.cijenaUsluge = cijenaUsluge;
    }
}
