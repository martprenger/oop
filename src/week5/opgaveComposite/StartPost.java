package week5.opgaveComposite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartPost extends Post {
    List<Post> posts;

    public StartPost(String user, String text) {
        super(user, text);
        posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public Post[] getResponses() {
        return posts.toArray(new Post[0]);
    }

    public Post[] find(String search) {
        List<Post> found = new ArrayList<>();
        for (Post post : posts) {
            if (post.getText().contains(search)) {
                found.add(post);
            }
            Post[] subFound = (post).find(search);
            found.addAll(Arrays.asList(subFound));
        }
        return found.toArray(new Post[0]);
    }

    public int getNumberOfPostings() {
        int sum = 1;
        for (Post post : posts) {
            sum += post.getNumberOfPostings();
        }
        return sum;
    }

    public void addResponse(Post post) {
        posts.add(post);
    }
}
