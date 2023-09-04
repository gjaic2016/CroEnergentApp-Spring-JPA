package hr.apisit.energent.domain;

public enum ContractType {

    FIXED("FIXED"),
    INDEFINITE("INDEFINITE");

    private String contractType;

    ContractType(String contractType) {
        this.contractType=contractType;
    }

    public String getContractType() {
        return contractType;
    }
}
