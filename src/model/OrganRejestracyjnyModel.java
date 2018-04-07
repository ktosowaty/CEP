package model;

public class OrganRejestracyjnyModel {
    private int IDOR;
    private String NazwaOR;

    public OrganRejestracyjnyModel(int IDOR, String nazwaOR) {
        this.IDOR = IDOR;
        NazwaOR = nazwaOR;
    }

    public OrganRejestracyjnyModel(String nazwaOR) {
        NazwaOR = nazwaOR;
    }

    public int getIDOR() {
        return IDOR;
    }

    public void setIDOR(int IDOR) {
        this.IDOR = IDOR;
    }

    public String getNazwaOR() {
        return NazwaOR;
    }

    public void setNazwaOR(String nazwaOR) {
        NazwaOR = nazwaOR;
    }
}
