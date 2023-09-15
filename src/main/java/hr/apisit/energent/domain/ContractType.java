package hr.apisit.energent.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONTRACT_TYPE")
@Data
@NoArgsConstructor
public class ContractType {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    public ContractType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
