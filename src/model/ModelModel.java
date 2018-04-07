package model;

public class ModelModel {
    private int IDModelu;

    private String NazwaModelu;

    public ModelModel(String nazwaModelu) {
        NazwaModelu = nazwaModelu;
    }

    public ModelModel(int IDModelu, String nazwaModelu) {
        this.IDModelu = IDModelu;
        NazwaModelu = nazwaModelu;
    }

    public int getIDModelu() {
        return IDModelu;
    }

    public void setIDModelu(int IDModelu) {
        this.IDModelu = IDModelu;
    }

    public String getNazwaModelu() {
        return NazwaModelu;
    }

    public void setNazwaModelu(String nazwaModelu) {
        NazwaModelu = nazwaModelu;
    }
}
