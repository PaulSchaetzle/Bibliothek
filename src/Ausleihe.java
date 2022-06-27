import java.time.LocalDate;

public class Ausleihe {

    private Medium medium;
    private LocalDate ausleihDatum;
    private AusleihBerechtigter ausleihBerechtigter;
    private LocalDate rueckgabeFrist;
    private int verlaengerung;

    Ausleihe(AusleihBerechtigter ausleihBerechtigter, Medium medium){
        this.ausleihBerechtigter = ausleihBerechtigter;
        this.medium = medium;
        ausleihDatum = LocalDate.now();
        rueckgabeFrist = ausleihDatum.plusDays(14);
        verlaengerung = 0;
    }

    public void ausleihVerlaengern() throws Exception{
        if(verlaengerung == 0){
            this.rueckgabeFrist = rueckgabeFrist.plusDays(14);
            verlaengerung++;
        }
        else if(verlaengerung == 2){
            throw new Exception("Die maximale Anzahl an Verlängerungen wurde schon erreicht.");
        }
        else{
            this.rueckgabeFrist = rueckgabeFrist.plusDays(7);
            verlaengerung++;
        }
    }

    public Medium getMedium() {
        return medium;
    }
}
