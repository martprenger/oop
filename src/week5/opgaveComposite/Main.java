package week5.opgaveComposite;

public class Main {
    public static Post generateTestPost() {
        FirstPost startPost = new FirstPost("Arraylist nullpointer exception", "foo123", "Ik gebruik een ArrayList in een Java-project maar krijg de hele tijd een nullpointer exception. Waarom???");
        startPost.addResponse(new SinglePost("bar", "Weet je zeker dat de oorzaak van de exception bij de ArrayList ligt?"));
        StartPost startPost2 = new StartPost("Javaguru", "Mogelijk heb je geen instantie gemaakt van de ArrayList.");
        startPost.addResponse(startPost2);
        startPost2.addResponse(new SinglePost("foo123", "Hoe kan ik  zien of ik een instantie heb gemaakt?"));
        startPost2.addResponse(new SinglePost("Javaguru", "Met het keyword new worden instanties gemaakt. Staat ergens in jouw code new ArrayList?"));
        startPost2.addResponse(new SinglePost("foo123", "Nee"));
        startPost2.addResponse(new SinglePost("bar", "n00b"));
        return startPost;
    }

    public static void main(String[] args) {
        Post startPost = generateTestPost();

        System.out.println("Totaal aantal postings (start-post + alle reacties): "+startPost.getNumberOfPostings());
        System.out.println();
        System.out.println("================");
        System.out.println();
        startPost.printPostings(new PostPrinterConsole());
        System.out.println("================");
        System.out.println();
        System.out.println("Zoeken naar het woord 'instantie':");
        for(Post post : startPost.find("instantie")) {
            System.out.println("Auteur: "+post.getUser());
            System.out.println("Tekst:  "+post.getText());
        }

    }
}
