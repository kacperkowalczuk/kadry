public class Main {
    public static void main(String[] args) throws java.io.FileNotFoundException{
        
        ControllerPracownik controllerPracownik  = new ControllerPracownik();
        controllerPracownik.dodajPracownika(1,"Anna","Nowak",23,"Ekspedient", 5, 2100, 31);
        controllerPracownik.dodajPracownika(2, "Michal", "Kanarg", 32, "Mechanik", 14, 5450, 212);
        controllerPracownik.edytujPracownika(2);
        controllerPracownik.wypiszPracownika(2);
        controllerPracownik.edytujPracownika(1);
        controllerPracownik.wypiszPracownika(1);
        controllerPracownik.usunPracownika(2);
        System.out.println("Usunieto");
        controllerPracownik.wypiszPracownika(2);
    }
}
