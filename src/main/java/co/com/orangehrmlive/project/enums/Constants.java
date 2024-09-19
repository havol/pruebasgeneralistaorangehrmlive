package co.com.orangehrmlive.project.enums;

public enum Constants {

    INFORMATION_EXCEL("Informacion"),
    INFORMATION_PRODUCTS("InformacionPrdocut");

    String constant;

    Constants(String menssage) {
        this.constant = menssage;
    }

    public String getValue() {
        return constant;
    }

}