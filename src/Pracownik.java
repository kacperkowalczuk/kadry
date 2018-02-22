import java.util.Scanner;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private int wiek;
    private String stanowisko;
    private int lataDoswiadczenia;
    private int placa;
    private int premia;

    public Pracownik()
    {

    }
    public Pracownik(String imie, String nazwisko, int wiek, String stanowisko, int lataDoswiadczenia)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.stanowisko = stanowisko;
        this.lataDoswiadczenia = lataDoswiadczenia;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getLataDoswiadczenia() {
        return lataDoswiadczenia;
    }

    public void setLataDoswiadczenia(int lataDoswiadczenia) {
        this.lataDoswiadczenia = lataDoswiadczenia;

    }
    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public int getPremia() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia = premia;
    }
}
