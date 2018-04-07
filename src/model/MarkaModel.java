package model;

public class MarkaModel {
    private int IDMarki;
    private String NazwaMarki;

    public MarkaModel(int IDMarki, String nazwaMarki) {
        this.IDMarki = IDMarki;
        NazwaMarki = nazwaMarki;
    }

    public MarkaModel(String nazwaMarki) {

        NazwaMarki = nazwaMarki;
    }

    public int getIDMarki() {
        return IDMarki;
    }

    public void setIDMarki(int IDMarki) {
        this.IDMarki = IDMarki;
    }

    public String getNazwaMarki() {
        return NazwaMarki;
    }

    public void setNazwaMarki(String nazwaMarki) {
        NazwaMarki = nazwaMarki;
    }
}
