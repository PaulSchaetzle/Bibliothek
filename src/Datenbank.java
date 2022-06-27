import java.util.HashMap;
import java.util.Map;

public class Datenbank {

    // Singleton-Pattern
    private Datenbank() {};

    private static Datenbank datenbank = null;

    public static Datenbank getInstance () {
        if (datenbank == null) {
            datenbank = new Datenbank();
        }
        return datenbank;
    }


    private Map<String, Medium> medien  = new HashMap<>();

    // "Table" fuer Ausleihberechtigte
    private Map<String, AusleihBerechtigter> ausleihBerechtigteMap = new HashMap<>();

    // Mediums Methoden
    public Medium gibMedium(String name){
        return medien.get(name);
    }

    public String[] gibAlleMedien() {
        String[] result = new String[medien.size()];
        int i = 0;
        for (String s : medien.keySet()) {
            result[i] = s;
            i++;
        }
        return result;
    }

    public void hinzufuegenMedium(Medium m) {
        medien.put(m.getName(), m);
    }

    public void loeschenMedium(String name){
        medien.remove(name);
    }

    // Ausleih Berechtige Methoden

    public AusleihBerechtigter gibAusleihBerechtigter(String name) {
        return ausleihBerechtigteMap.get(name);
    }

    public String[] gibAlleAusleihBerechtigte() {
        String[] result = new String[ausleihBerechtigteMap.size()];
        int i = 0;
        for (String s : ausleihBerechtigteMap.keySet()) {
            result[i] = s;
            i++;
        }
        return result;
    }

    public void hinzufuegenAusleihBerechtigter(AusleihBerechtigter a) {
        ausleihBerechtigteMap.put(a.getName(), a);
    }

    public void loeschenAusleihBerechtigter(String name) {
        ausleihBerechtigteMap.remove(name);
    }
}
