public class Auswaehlen {
    static String waehleAus(String[] alternativen){
        String index_string;
        int index;
        for(int i = 0; i < alternativen.length; i++) {
            System.out.println((i+1) + " " + alternativen[i]);
        }
        while(true) {
            index_string = Eingabe.eingeben("Bitte geben Sie die gewuenschte Nummer ein!");
            try {
                index = Integer.parseInt(index_string);
                if (index > alternativen.length || index <=0) {
                    System.out.println("Ungueltiger Index");
                } else {
                    break;
                }
            } catch (Exception e) {
                if (index_string == null) {
                    System.out.println("Kein Index eingegeben");
                } else {
                    System.out.println("Ungueltiger Index");
                }

            }
        }
        return alternativen[index-1];
    }
}

