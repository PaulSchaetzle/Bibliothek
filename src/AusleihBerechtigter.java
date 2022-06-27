
import java.util.HashMap;
import java.util.Map;

public class AusleihBerechtigter {
    private String name;
    private String passwort;
    private Map<String, Ausleihe> ausgelieheneMedien = new HashMap();

    public String getName() {
        return name;
    }

    public String getPasswort() {
        return passwort;
    }

    public String[] getAusleihen() {
        String[] result = new String[ausgelieheneMedien.size()];
        int i = 0;
        for (String s : ausgelieheneMedien.keySet()) {
            result[i] = s;
            i++;
        }
        return result;
    }

    public AusleihBerechtigter(String name, String passwort) {
        this.name = name;
        this.passwort = passwort;
    }

    public void ausleihen(String name) throws Exception {
        Datenbank datenbank = Datenbank.getInstance();
        if (datenbank.gibMedium(name).getAusleihe() == null) {
            Ausleihe ausleihe = new Ausleihe(this, datenbank.gibMedium(name));
            ausgelieheneMedien.put(name, ausleihe);
            datenbank.gibMedium(name).setAusleihe(ausleihe); // Ausleihe in Medium schreiben das festgestellt werden wann buch wieder verfügbar ist.
        } else {
            throw new Exception("Buch ist bereits ausgeliehen");
        }
    }

    public void zurueckgeben(String name) {
        ausgelieheneMedien.remove(name);
        Datenbank datenbank = Datenbank.getInstance();
        datenbank.gibMedium(name).setAusleihe(null);
    }

    public void verlaengern(String name) throws Exception {
        ausgelieheneMedien.get(name).ausleihVerlaengern();
    }
}
