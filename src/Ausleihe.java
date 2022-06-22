import java.time.LocalDate;

public class Ausleihe {
    private Medium medium;
    private LocalDate ausleihDatum;
    private AusleihBerechtigte ausleihBerechtigte;
    private LocalDate rueckgabeFrist;
    private int verlaengerung;
    private boolean vorbestellung;

    Ausleihe(AusleihBerechtigte ausleihBerechtigte, Medium medium){
        this.ausleihBerechtigte = ausleihBerechtigte;
        this.medium = medium;
    }

    public void ausleihVerlaengern(){
        if(verlaengerung == 0){
            this.rueckgabeFrist = rueckgabeFrist.plusDays(14);
            verlaengerung++;
        }
        else if(verlaengerung == 2){
            System.out.println("Die maximale Anzahl an Verlängerungen wurde schon erreicht.");
        }
        else{
            this.rueckgabeFrist = rueckgabeFrist.plusDays(7);
            verlaengerung++;
        }
    }

    public void mediumVorbestellen(){
        
    }
}
