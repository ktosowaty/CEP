package model;

public class UbezpieczenieModel {
    private String NrPolisy;
    private String ZakladUbezpieczeniowy;

    public UbezpieczenieModel(String nrPolisy, String zakladUbezpieczeniowy) {
        NrPolisy = nrPolisy;
        ZakladUbezpieczeniowy = zakladUbezpieczeniowy;
    }

    public String getNrPolisy() {
        return NrPolisy;
    }

    public void setNrPolisy(String nrPolisy) {
        NrPolisy = nrPolisy;
    }

    public String getZakladUbezpieczeniowy() {
        return ZakladUbezpieczeniowy;
    }

    public void setZakladUbezpieczeniowy(String zakladUbezpieczeniowy) {
        ZakladUbezpieczeniowy = zakladUbezpieczeniowy;
    }
}
