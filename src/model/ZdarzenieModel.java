package model;

public class ZdarzenieModel {
    private int IDZdarzenia;
    private String NazwaZdarzenia;
    private String OpisZdarzenia;

    public ZdarzenieModel(int IDZdarzenia, String nazwaZdarzenia, String opisZdarzenia) {
        this.IDZdarzenia = IDZdarzenia;
        NazwaZdarzenia = nazwaZdarzenia;
        OpisZdarzenia = opisZdarzenia;
    }

    public int getIDZdarzenia() {
        return IDZdarzenia;
    }

    public void setIDZdarzenia(int IDZdarzenia) {
        this.IDZdarzenia = IDZdarzenia;
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
}
