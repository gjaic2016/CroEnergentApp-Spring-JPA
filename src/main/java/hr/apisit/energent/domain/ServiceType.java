package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SERVICE_TYPE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceType {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String naziv;

//    @OneToOne(mappedBy = "vrstaUsluge")
//    @JsonIgnore
//    private ServiceProvider serviceProvider;

//    public ServiceType(Integer id, String naziv) {
//        this.id = id;
//        this.naziv = naziv;
//    }
}
