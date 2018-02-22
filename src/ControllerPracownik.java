import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControllerPracownik {

    private Pracownik[] pracownicy;

    void dodajPracownika(int index, String imie, String nazwisko, int wiek, String stanowisko, int lataDoswiadczenia)
    {
        pracownicy[index] = new Pracownik(imie, nazwisko, wiek, stanowisko, lataDoswiadczenia);
    }
    void edytujPracownika(int index)
    {
        if(pracownicy[index] != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Imie?");
            pracownicy[index].setImie(sc.nextLine());
            System.out.println("Nazwisko?");
            pracownicy[index].setNazwisko(sc.nextLine());
            System.out.println("Wiek?");
            pracownicy[index].setWiek(sc.nextInt());
            System.out.println("Stanowisko?");
            pracownicy[index].setStanowisko(sc.nextLine());
            System.out.println("Lata Doświadczenia?");
            pracownicy[index].setLataDoswiadczenia(sc.nextInt());
        }
        else
        {
            System.out.println("W podanym indeksie nikogo nie ma! Stwórz nowego pracownika.");
        }
    }
    void usunPracownika(int index) {
        if(pracownicy[index] != null) {
            pracownicy[index] = null;
        }
        else
        {
            System.out.println("Nie ma w tym indeksie nikogo do usunięcia.");
        }
    }
    void wczytajZPlikuTekstowego(int index) throws FileNotFoundException
    {
        File file = new File("place.txt");
        Scanner odczyt = new Scanner(file);
        for (int i = 0; i < file.length(); i++)
        {
            if(odczyt.nextLine() == pracownicy[index].getStanowisko())
            {
                int placaBazowa = odczyt.nextInt();
                pracownicy[index].setPremia(odczyt.nextInt());
                pracownicy[index].setPlaca(placaBazowa+(pracownicy[index].getPremia()*pracownicy[index].getLataDoswiadczenia()));
            }
        }
    }
}