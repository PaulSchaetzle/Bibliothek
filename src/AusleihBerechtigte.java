import java.util.HashMap;
import java.util.Map;

public class AusleihBerechtigte {
    private Map<String, AusleihBerechtigter> ausleihBerechtigteMap = new HashMap<>();

    private static AusleihBerechtigte einzigeInstanz = null;

    static AusleihBerechtigte gibEinzigeInstanz() {
        if (einzigeInstanz == null)
            einzigeInstanz = new AusleihBerechtigte();
        return einzigeInstanz;
    }

    private AusleihBerechtigte() {}

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

    public void hinzufuegen(AusleihBerechtigter a) {
        ausleihBerechtigteMap.put(a.getName(), a);
    }

    public void loeschen(String name) {
        ausleihBerechtigteMap.remove(name);
    }
}