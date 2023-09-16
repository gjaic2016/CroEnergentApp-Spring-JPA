package hr.apisit.energent.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= FixedTermContract.class, name = "FIXED"),
        @JsonSubTypes.Type(value= IndefiniteContract.class, name = "INDEFINITE")
})
@Data
@ToString
public abstract class Contract {

    private Integer id;

    private String tip;

    private ServiceProvider pruzateljUsluge;

    private Household kucanstvo;

    public Contract(){}

    public Contract(Integer id, String tip, ServiceProvider pruzateljUsluge, Household kucanstvo) {
        this.id = id;
        this.tip = tip;
        this.pruzateljUsluge = pruzateljUsluge;
        this.kucanstvo = kucanstvo;
    }

//    @Override
//    public String toString() {
//        return "Contract{" +
//                "id=" + id +
//                ", tip='" + tip + '\'' +
//                ", pruzateljUsluge=" + pruzateljUsluge +
//                ", kucanstvo=" + kucanstvo +
//                '}';
//    }
}
