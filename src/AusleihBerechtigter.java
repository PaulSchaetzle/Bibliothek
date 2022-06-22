
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AusleihBerechtigter {
    private String name;
    private String passwort;
//    private Vector<Ausleihe> ausgelieheneMedien = new Vector<>();
    private Map<String, Ausleihe> ausgelieheneMedien = new HashMap();

    public String getName() {
        return name;
    }

    public String getPasswort() {
        return passwort;
    }

    public AusleihBerechtigter(String name, String passwort) {
        this.name = name;
        this.passwort = passwort;
    }

    public void ausleihen(String name) {
        ausgelieheneMedien.put(name, new Ausleihe(this, Medien.gibEinzigeInstanz().gibMedium(name)));
    }

    public void zurueckgeben(String name){
        ausgelieheneMedien.get(name).getMedium();
        ausgelieheneMedien.remove(name);
    }
}
