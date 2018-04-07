package view;

import java.sql.Date;

public class OwnerEventHistoryView {
    private String VIN;
    private String NazwaZdarzenia;
    private String OpisZdarzenia;
    private Date DataZdarzenia;

    public OwnerEventHistoryView(String VIN, String nazwaZdarzenia, String opisZdarzenia, Date dataZdarzenia) {
        this.VIN = VIN;
        NazwaZdarzenia = nazwaZdarzenia;
        OpisZdarzenia = opisZdarzenia;
        DataZdarzenia = dataZdarzenia;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getNazwaZdarzenia() {
        return NazwaZdarzenia;
    }

    public void setNazwaZdarzenia(String nazwaZdarzenia) {
        NazwaZdarzenia = nazwaZdarzenia;
    }

    public String getOpisZdarzenia() {
        return OpisZdarzenia;
    }

    public void setOpisZdarzenia(String opisZdarzenia) {
        OpisZdarzenia = opisZdarzenia;
    }

    public Date getDataZdarzenia() {
        return DataZdarzenia;
    }

    public void setDataZdarzenia(Date dataZdarzenia) {
        DataZdarzenia = dataZdarzenia;
    }
}
