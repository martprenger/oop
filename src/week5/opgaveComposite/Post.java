package week5.opgaveComposite;

public abstract class Post {
    String user;
    String text;

    public Post(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }
    public int getNumberOfPostings() {
        return 1;
    }

    public Post[] getResponses() {
        return new Post[0];
    }

    public Post[] find(String search) {
        return new Post[0];
    }

    public void printPostings(PostPrinter printer) {
        printer.printPostings(0, this);
    }

    @Override
    public String toString() {
        return "Auteur: " + user +
                "\n" + text;
    }


}
