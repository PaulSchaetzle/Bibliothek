import java.util.Date;

public class Bibliothek {

    public static void main(String[] Args) {
        String[] menu = new String[]{"Ausleihberechtigte Person anlegen", "Buch ausleihen", "Buch verlaengern", "Buch zurueckgeben", "Medium in Bestand aufnehmen", "Beenden"};
        Datenbank.getInstance().hinzufuegenAusleihBerechtigter(new AusleihBerechtigter("Paul", "1234"));
        Datenbank.getInstance().hinzufuegenMedium(new Buch("Herr der Ringe", "J.R.R Tolkien", "KA"));
        AusleihBerechtigter ausleihBerechtigter;
        loops:
        while(true){
            switch (Auswaehlen.waehleAus(menu)) {
                case "Ausleihberechtigte Person anlegen":
                    System.out.println("Ausleihberechtigte Person anlegen");
                    Datenbank.getInstance().hinzufuegenAusleihBerechtigter(new AusleihBerechtigter(Eingabe.eingeben("Benutzername eingeben"), Eingabe.eingeben("Passwort eingeben")));
                    System.out.println("hello");
                    break;

                case "Buch ausleihen":
                    System.out.println("Ausleihberechtigte Person auswaehlen");
                    ausleihBerechtigter = Datenbank.getInstance().gibAusleihBerechtigter(Auswaehlen.waehleAus(Datenbank.getInstance().gibAlleAusleihBerechtigte()));
                    try {
                        ausleihBerechtigter.ausleihen(Auswaehlen.waehleAus(Datenbank.getInstance().gibAlleMedien()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Buch verlaengern":
                    System.out.println("Ausleihberechtigte Person auswaehlen");
                    ausleihBerechtigter = Datenbank.getInstance().gibAusleihBerechtigter(Auswaehlen.waehleAus(Datenbank.getInstance().gibAlleAusleihBerechtigte()));
                    try {
                        ausleihBerechtigter.verlaengern(Auswaehlen.waehleAus(ausleihBerechtigter.getAusleihen()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Buch zurueckgeben":
                    System.out.println("Ausleihberechtigte Person auswaehlen");
                    ausleihBerechtigter = Datenbank.getInstance().gibAusleihBerechtigter(Auswaehlen.waehleAus(Datenbank.getInstance().gibAlleAusleihBerechtigte()));
                    ausleihBerechtigter.zurueckgeben(Auswaehlen.waehleAus(ausleihBerechtigter.getAusleihen()));
                    break;

                case "Medium in Bestand aufnehmen":
                    System.out.println("Buch in Bestand aufnehmen");
                    Datenbank.getInstance().hinzufuegenMedium(new Buch(Eingabe.eingeben("Titel des Buches eingeben"), Eingabe.eingeben("Author des Buches"), Eingabe.eingeben("Verlag des Buches")));
                    break;

                case "Beenden":
                    break loops;

            }
        }
    }
}
