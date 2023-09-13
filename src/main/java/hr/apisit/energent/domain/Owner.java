package hr.apisit.energent.domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Entity
@Table(name = "OWNER")
@Data
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "IME")
    private String ime;

    @Column(name = "PREZIME")
    private String prezime;

    @Column(name = "DATUM_RODENJA")
    private LocalDate datumRodenja;

    @Column(name = "OIB")
    private String oib;

    public Owner(Integer id, String ime, String prezime, LocalDate datumRodenja, String oib) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodenja = datumRodenja;
        this.oib = oib;
    }

}
