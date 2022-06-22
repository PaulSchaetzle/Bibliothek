public class AusleihBerechtigter {
    private String name;
    private String passwort;
    private ausgelieheneMedien

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

}
