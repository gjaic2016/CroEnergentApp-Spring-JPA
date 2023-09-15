package hr.apisit.energent.domain;

public enum ContractType2 {

    FIXED("FIXED"),
    INDEFINITE("INDEFINITE");

    private String contractType;

    ContractType2(String contractType) {
        this.contractType=contractType;
    }

    public String getContractType() {
        return contractType;
    }
}
