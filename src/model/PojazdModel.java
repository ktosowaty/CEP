package model;

import java.sql.Date;

public class PojazdModel {
    private String VIN;
    private Date WaznoscPrzegladu;
    private Date WaznoscUbezpieczenia;
    private boolean StatusKradziezy;
    private String NrRejestracyjny;
    private Date DataProdukcji;
    private String Moc;
    private String Pojemnosc;
    private String RodzajPaliwa;
    private int IDMarki;
    private int IDModelu;
    private String NrPolisy;
    private int IDOR;
    private  boolean StatusRejestracji;

    public PojazdModel(){}

    public PojazdModel(String VIN, Date waznoscPrzegladu, Date waznoscUbezpieczenia, boolean statusKradziezy,
                       String nrRejestracyjny, Date dataProdukcji, String moc, String pojemnosc,
                       String rodzajPaliwa, int IDMarki, int IDModelu, String nrPolisy, int IDOR, boolean statusRejestracji) {
        this.VIN = VIN;
        WaznoscPrzegladu = waznoscPrzegladu;
        WaznoscUbezpieczenia = waznoscUbezpieczenia;
        StatusKradziezy = statusKradziezy;
        NrRejestracyjny = nrRejestracyjny;
        DataProdukcji = dataProdukcji;
        Moc = moc;
        Pojemnosc = pojemnosc;
        RodzajPaliwa = rodzajPaliwa;
        this.IDMarki = IDMarki;
        this.IDModelu = IDModelu;
        NrPolisy = nrPolisy;
        this.IDOR = IDOR;
        StatusRejestracji = statusRejestracji;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Date getWaznoscPrzegladu() {
        return WaznoscPrzegladu;
    }

    public void setWaznoscPrzegladu(Date waznoscPrzegladu) {
        WaznoscPrzegladu = waznoscPrzegladu;
    }

    public Date getWaznoscUbezpieczenia() {
        return WaznoscUbezpieczenia;
    }

    public void setWaznoscUbezpieczenia(Date waznoscUbezpieczenia) {
        WaznoscUbezpieczenia = waznoscUbezpieczenia;
    }

    public boolean isStatusKradziezy() {
        return StatusKradziezy;
    }

    public void setStatusKradziezy(boolean statusKradziezy) {
        StatusKradziezy = statusKradziezy;
    }

    public String getNrRejestracyjny() {
        return NrRejestracyjny;
    }

    public void setNrRejestracyjny(String nrRejestracyjny) {
        NrRejestracyjny = nrRejestracyjny;
    }

    public Date getDataProdukcji() {
        return DataProdukcji;
    }

    public void setDataProdukcji(Date dataProdukcji) {
        DataProdukcji = dataProdukcji;
    }

    public String getMoc() {
        return Moc;
    }

    public void setMoc(String moc) {
        Moc = moc;
    }

    public String getPojemnosc() {
        return Pojemnosc;
    }

    public void setPojemnosc(String pojemnosc) {
        Pojemnosc = pojemnosc;
    }

    public String getRodzajPaliwa() {
        return RodzajPaliwa;
    }

    public void setRodzajPaliwa(String rodzajPaliwa) {
        RodzajPaliwa = rodzajPaliwa;
    }

    public int getIDMarki() {
        return IDMarki;
    }

    public void setIDMarki(int IDMarki) {
        this.IDMarki = IDMarki;
    }

    public int getIDModelu() {
        return IDModelu;
    }

    public void setIDModelu(int IDModelu) {
        this.IDModelu = IDModelu;
    }

    public String getNrPolisy() {
        return NrPolisy;
    }

    public void setNrPolisy(String nrPolisy) {
        NrPolisy = nrPolisy;
    }

    public int getIDOR() {
        return IDOR;
    }

    public void setIDOR(int IDOR) {
        this.IDOR = IDOR;
    }

    public boolean isStatusRejestracji() {
        return StatusRejestracji;
    }

    public void setStatusRejestracji(boolean statusRejestracji) {
        StatusRejestracji = statusRejestracji;
    }
}
