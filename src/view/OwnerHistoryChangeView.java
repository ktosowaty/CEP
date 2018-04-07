package view;

import java.sql.Date;

public class OwnerHistoryChangeView {
    private String VIN;
    private String PESEL_nowy;
    private String PESEL_stary;
    private Date date;

    public OwnerHistoryChangeView(String VIN, String PESEL_nowy, String PESEL_stary, Date date) {
        this.VIN = VIN;
        this.PESEL_nowy = PESEL_nowy;
        this.PESEL_stary = PESEL_stary;
        this.date = date;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getPESEL_nowy() {
        return PESEL_nowy;
    }

    public void setPESEL_nowy(String PESEL_nowy) {
        this.PESEL_nowy = PESEL_nowy;
    }

    public String getPESEL_stary() {
        return PESEL_stary;
    }

    public void setPESEL_stary(String PESEL_stary) {
        this.PESEL_stary = PESEL_stary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
