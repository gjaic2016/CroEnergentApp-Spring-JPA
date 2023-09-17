//package hr.apisit.energent.domain;
//
//import com.fasterxml.jackson.annotation.JsonTypeName;
//import lombok.*;
//
//import java.time.LocalDate;
//
////@NoArgsConstructor
////@AllArgsConstructor
////@Builder
//
//@JsonTypeName("FIXED")
//public class FixedTermContract implements FixedTerm{
//
//    private LocalDate contractStart;
//
//    private LocalDate contractEnd;
//
//    public FixedTermContract(){
//        super();
//    }
//
//    public FixedTermContract(LocalDate contractStart, LocalDate contractEnd) {
//        this.contractStart = contractStart;
//        this.contractEnd = contractEnd;
//    }
//
//    public FixedTermContract(Integer id, String tip, ServiceProvider pruzateljUsluge, Household kucanstvo, LocalDate contractStart, LocalDate contractEnd) {
//        super(id, tip, pruzateljUsluge, kucanstvo);
//        this.contractStart = contractStart;
//        this.contractEnd = contractEnd;
//    }
//
//    public LocalDate getContractStart() {
//        return contractStart;
//    }
//
//    @Override
//    public void setContractStart(LocalDate contractStart) {
//        this.contractStart = contractStart;
//    }
//
//    public LocalDate getContractEnd() {
//        return contractEnd;
//    }
//
//    @Override
//    public void setContractEnd(LocalDate contractEnd) {
//        this.contractEnd = contractEnd;
//    }
//
//    @Override
//    public String toString() {
//        return "FixedTermContract{" +
//                "contractStart=" + contractStart +
//                ", contractEnd=" + contractEnd +
//                '}';
//    }
//}
