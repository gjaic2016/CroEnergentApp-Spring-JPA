package hr.apisit.energent.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner {

    private Integer id;
    private String ime;
    private String prezime;
    private LocalDate datumRodenja;
    private String oib;

    public Owner(Integer id, String ime, String prezime, LocalDate datumRodenja, String oib) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodenja = datumRodenja;
        this.oib = oib;
    }

}
