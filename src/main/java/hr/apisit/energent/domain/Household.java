package hr.apisit.energent.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Getter
//@Setter
//@ToString
@Entity
@Table(name = "HOUSEHOLD")
@Data
@NoArgsConstructor
public class Household  {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "ADDRESS")
    private String adresa;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "HOUSEHOLD_OWNER",
            joinColumns = @JoinColumn(name = "HOUSEHOLD_ID"),
            inverseJoinColumns = @JoinColumn (name = "OWNER_ID")
    )
    private List<Owner> vlasnik;

    public Household(Integer id, String adresa, List<Owner> vlasnik) {
        this.id = id;
        this.adresa = adresa;
        this.vlasnik = vlasnik;
    }

}
