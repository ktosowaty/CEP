package model;

import java.sql.Date;

public class HistoriaPojazduModel {
    private int IDZdarzenia;
    private Date DataZdarzenia;
    private String VIN;

    public HistoriaPojazduModel(int IDZdarzenia, Date dataZdarzenia, String VIN) {
        this.IDZdarzenia = IDZdarzenia;
        DataZdarzenia = dataZdarzenia;
        this.VIN = VIN;
    }

    public int getIDZdarzenia() {
        return IDZdarzenia;
    }

    public void setIDZdarzenia(int IDZdarzenia) {
        this.IDZdarzenia = IDZdarzenia;
    }

    public Date getDataZdarzenia() {
        return DataZdarzenia;
    }

    public void setDataZdarzenia(Date dataZdarzenia) {
        DataZdarzenia = dataZdarzenia;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}
