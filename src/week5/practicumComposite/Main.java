package week5.practicumComposite;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu mainmenu = new Menu("Main menu");
        Menu officemenu = new Menu("Office");
        Menu gamesmenu = new Menu("Games");
        Menu singleplayermenu = new Menu("Single player");
        Menu multiplayermenu = new Menu("Multi player");

        mainmenu.add(new MenuOption("Terminal", "alacritty"));
        mainmenu.add(new MenuOption("Tekst editor", "nvim"));
        officemenu.add(new MenuOption("LibreOffice Calc", "alacritty --command nvim"));
        officemenu.add(new MenuOption("LibreOffice Writer", "libreoffice --writer"));
        singleplayermenu.add(new MenuOption("Minesweeper", "gnome-mines"));
        singleplayermenu.add(new MenuOption("Sudoku", "gnome-sudoku"));
        multiplayermenu.add(new MenuOption("Tic Tac Toe", "gnome-taquin"));
        multiplayermenu.add(new MenuOption("Chess", "gnome-chess"));

        gamesmenu.add(singleplayermenu);
        gamesmenu.add(multiplayermenu);
        mainmenu.add(gamesmenu);
        mainmenu.add(officemenu);
        officemenu.add(mainmenu);

        Menu currentMenu = mainmenu;

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("*** "+currentMenu.getTitle()+" ***");
            System.out.println();
            for (int number = 1; number<=currentMenu.menuOptionCount(); number++) {
                Component menuOption = currentMenu.getMenuItem(number);
                System.out.println(number + ". " + menuOption.getTitle());
            }

            System.out.println();
            System.out.println(currentMenu.menuOptionCount()+1 + ". Show menu tree");
            System.out.println("0. Quit");
            choice = Integer.parseInt(scanner.nextLine());
            if ((choice > 0) && (choice <= currentMenu.menuOptionCount())) {
                Component menuItem = currentMenu.getMenuItem(choice);
                if (menuItem instanceof MenuOption) {
                    ((MenuOption)menuItem).execute();
                }
                if (menuItem instanceof Menu) {
                    currentMenu=(Menu)menuItem;
                }
            }

            if (choice == currentMenu.menuOptionCount()+1) {
                System.out.println();
                System.out.println("*** Menu tree ***");
                System.out.println();
                Set<Menu> visited = new HashSet<>();
                visited.add(currentMenu);

                printMenuTree(currentMenu, 0, visited);
            }
        } while(choice!=0);
    }

    public static void printMenuTree(Menu menu, int level, Set<Menu> visited) {
        for (int number = 1; number<=menu.menuOptionCount(); number++) {
            Component menuOption = menu.getMenuItem(number);
            if (menuOption instanceof Menu && !visited.contains(menuOption)) {
                for (int i=0; i<level; i++) {
                    System.out.print("  ");
                }
                System.out.println(number + ". " + menuOption.getTitle());
                visited.add((Menu)menuOption);
                printMenuTree((Menu)menuOption, level+1, visited);
            } else {
                for (int i=0; i<level; i++) {
                    System.out.print("  ");
                }
                System.out.println(number + ". " + menuOption.getTitle());
            }
        }
    }
}
