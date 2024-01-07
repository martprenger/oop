package week5.opgaveComposite;

public class PostPrinterConsole implements PostPrinter{
    @Override
    public void printPostings(int level, Post post) {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println("Auteur: " + post.getUser());
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(post.getText());
        System.out.println();

        for (Post response : post.getResponses()) {
            printPostings(level + 1, response);
        }
    }

    @Override
    public void printFirstPosting(Post post) {
        System.out.println("Titel: " + ((FirstPost) post).getTitel());
        printPostings(0, post);
    }
}
