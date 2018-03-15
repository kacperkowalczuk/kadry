import javax.print.attribute.PrintJobAttributeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControllerPracownik {

    private Pracownik[] pracownicy;

    public ControllerPracownik(){
        pracownicy = new Pracownik[100];
    }


    public void dodajPracownika(int id, String imie, String nazwisko, int wiek, String stanowisko, int lataDoswiadczenia, double placa, int premia)
    {
        if(szukajPracownika(id) == null) {
            pracownicy[pierwszyWolnyIndeks()] = new Pracownik(id, imie, nazwisko, wiek, stanowisko, lataDoswiadczenia, placa, premia);
        }
    }

    public int pierwszyWolnyIndeks()
    {
        for(int i = 0; i < pracownicy.length; i++)
        {
            if(pracownicy[i] == null)
            {
                return i;
            }
        }
        System.out.println("Brak wolnych miejsc w tablicy!");
        return 101;
    }

    public void edytujPracownika(int idPracownika)
    {
        Pracownik pracownik = szukajPracownika(idPracownika);
        if(pracownik != null) {
            Scanner edit = new Scanner(System.in);
            System.out.println("Imie?");
            pracownik.setImie(edit.nextLine());
            System.out.println("Nazwisko?");
            pracownik.setNazwisko(edit.nextLine());
            System.out.println("Stanowkisko?");
            pracownik.setStanowisko(edit.nextLine());
            System.out.println("Wiek?");
            pracownik.setWiek(edit.nextInt());
            System.out.println("Lata Doswiadczenia?");
            pracownik.setLataDoswiadczenia(edit.nextInt());
        }
    }

    public Pracownik szukajPracownika(int idPracownika)
    {
        for(int i = 0; i < pracownicy.length; i++)
        {
            if(pracownicy[i] != null) {
                if (pracownicy[i].getId() == idPracownika) {
                    return pracownicy[i];
                }
            }
        }
        return null;
    }

    public boolean aktualizacja (Pracownik pracownik)
    {
        for(int i = 0; i < pracownicy.length; i++)
        {
            if(pracownik.getId() == pracownicy[i].getId())
            {
                pracownicy[i] = pracownik;
                return true;
            }
        }
        return false;
    }
    //TODO
    public void usunPracownika(int idPracownika) {//
        Pracownik pracownik = szukajPracownika(idPracownika);
        if(pracownik != null) {
            pracownik.setImie(null);
            pracownik.setNazwisko(null);
            pracownik.setStanowisko(null);
            pracownik.setWiek(-1);
            pracownik.setLataDoswiadczenia(-1);
            pracownik.setPlaca(-1);
            pracownik.setPremia(-1);
            aktualizacja(pracownik);
        }
        else
        {
            System.out.println("Nie ma jeszcze pracownika o takim id.");
        }
    }

    public void wczytajZPlikuTekstowego(int index) throws FileNotFoundException {
        File file = new File("pracownicy.txt");
        Scanner odczyt = new Scanner(file);

        while (odczyt.hasNextLine()) {
            int nrOsoby = 1;
            String lina = odczyt.nextLine();
            String[] tab = lina.split(" ");
            ;
        }

    }

    public boolean czyNull(Pracownik pracownik)
    {
        if(pracownik.getImie() == null && pracownik.getNazwisko() == null && pracownik.getStanowisko() == null && pracownik.getPlaca() == -1 && pracownik.getPremia() == -1 && pracownik.getWiek() == -1 && pracownik.getLataDoswiadczenia() == -1)
        {
            return true;
        }
        return false;
    }

    public void wypiszPracownika(int idPracownika)
    {
        Pracownik pracownik = szukajPracownika(idPracownika);
        if(!(czyNull(pracownik))) {
            System.out.println("Imie i nazwisko: " + pracownik.getImie() + " " + pracownik.getNazwisko() + "\nWiek: " + pracownik.getWiek() + "\nStanowisko: " + pracownik.getStanowisko() + "\nLata Doswiadczenia: " + pracownik.getLataDoswiadczenia() + "\nPremia: " + pracownik.getPremia() + "\nPlaca: " + pracownik.getPlaca());
        }
        else
        {
            System.out.println("Pracownik z tym id nie istnieje!");
        }
    }
}