import java.util.HashMap;
import java.util.Map;

public class Medien {
    private static Medien einzigeInstanz = null;

    static Medien gibEinzigeInstanz() {
        if (einzigeInstanz == null)
            einzigeInstanz = new Medien();
        return einzigeInstanz;
    }

    private Medien() {};

    Map<String, Medium> medien  = new HashMap<>();

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

    public void hinzufuegen(Medium m) {
        medien.put(m.getName(), m);
    }

    public void loeschen(String name){
        medien.remove(name);
    }
}
