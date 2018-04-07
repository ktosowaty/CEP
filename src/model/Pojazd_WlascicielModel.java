package model;

public class Pojazd_WlascicielModel {
    private String VIN;
    private String PESEL;

    public Pojazd_WlascicielModel(String VIN, String PESEL) {
        this.VIN = VIN;
        this.PESEL = PESEL;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
}
