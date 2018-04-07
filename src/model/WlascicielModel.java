package model;

public class WlascicielModel {
    private String PESEL;
    private String Imie;
    private String Nazwisko;
    private String Miejscowosc;
    private String Ulica;
    private String NumerDomu;

    public WlascicielModel(String PESEL, String imie, String nazwisko, String miejscowosc, String ulica, String numerDomu) {
        this.PESEL = PESEL;
        Imie = imie;
        Nazwisko = nazwisko;
        Miejscowosc = miejscowosc;
        Ulica = ulica;
        NumerDomu = numerDomu;
    }


    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        Miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    public String getNumerDomu() {
        return NumerDomu;
    }

    public void setNumerDomu(String numerDomu) {
        NumerDomu = numerDomu;
    }
}
