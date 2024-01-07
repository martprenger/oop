package week5.practicumComposite;

import java.util.ArrayList;

public class Menu extends Component {
    private ArrayList<Component> menuOptions;

    public Menu(String title) {
        super(title);
        this.menuOptions=new ArrayList<>();
    }

    public void add(Component menuOption) {
        menuOptions.add(menuOption);
    }

    public Component getMenuItem(int number) {
        return this.menuOptions.get(number-1);
    }

    public int menuOptionCount() {
        return this.menuOptions.size();
    }

}