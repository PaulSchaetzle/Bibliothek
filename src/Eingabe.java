import java.io.*;

public class Eingabe {
    static String eingeben(String eingabeAufforderung) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            System.out.print(eingabeAufforderung + " ");
            line = buffer.readLine();
            return line;
        }catch (Exception e){}
        return line;
    }
}
