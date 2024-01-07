package week5.practicumIterator;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Jan", "de Vries");
        Person person2 = new Person("Aukje", "De Jong");
        Person person3 = new Person("Els", "Visser");
        Person person4 = new Person("Hans", "Jansen");
        Person person5 = new Person("Jelmer", "Bakker");
        Team team1 = new Team();
        Team team2 = new Team();
        team1.addMember(person1);
        team1.addMember(person2);
        team1.addMember(person3);
        team1.addMember(person4);
        team2.addMember(person5);
        team2.addMember(person3);

        System.out.println("Leden team 1:");
        Iterator<Person> team1iterator = team1.createIterator();
        while (team1iterator.hasNext()) {
            Person member = team1iterator.next();
            System.out.println(member);
        }

        System.out.println("\nLeden team 2:");
        Iterator<Person> team2iterator = team2.createIterator();
        while (team2iterator.hasNext()) {
            Person member = team2iterator.next();
            System.out.println(member);
        }

    }
}
