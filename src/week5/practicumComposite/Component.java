package week5.practicumComposite;

abstract public class Component {

    private String title;

    public Component(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}