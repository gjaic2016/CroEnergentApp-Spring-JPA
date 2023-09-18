package hr.apisit.energent.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OWNER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IME")
    private String ime;

    @Column(name = "PREZIME")
    private String prezime;

    @Column(name = "DATUM_RODENJA")
    private LocalDate datumRodenja;

    @Column(name = "OIB")
    private String oib;

    @ManyToMany(mappedBy = "vlasnik")
    @JsonIgnore
    private List<Household> householdList;

}
