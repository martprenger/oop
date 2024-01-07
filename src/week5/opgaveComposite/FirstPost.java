package week5.opgaveComposite;

public class FirstPost extends StartPost{
    String titel;
    public FirstPost(String titel, String user, String text) {
        super(user, text);
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    public void printPostings(PostPrinter printer) {
        printer.printFirstPosting(this);
    }
}
