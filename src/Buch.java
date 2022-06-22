public class Buch implements Medium {
    private String name;
    private String author;
    private String publisher;

    public String getName() {
        return name;
    }

    Buch(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }
}
