package week5.practicumComposite;

import java.io.IOException;

public class MenuOption extends Component{
    private String commandline;

    public MenuOption(String title, String commandline) {
        super(title);
        this.commandline = commandline;
    }

    public void execute() {
        System.out.println("*** Executing "+commandline+" ***");
        String[] params = commandline.split(" ");
        try {
            Runtime.getRuntime().exec(params);
        } catch (IOException e) {
            System.out.println("Execution of "+commandline+" failed: "+e.getMessage());
        }
    }

}