package week5.practicumIterator;

public class Team implements Aggregate{

    public static final int MAX_NUMBER_OF_MEMBERS = 4;

    Person[] members = new Person[MAX_NUMBER_OF_MEMBERS];

    public void addMember(Person newMember) {
        int i=0;
        while(i<MAX_NUMBER_OF_MEMBERS && members[i]!=null) { i++; }
        if (i<MAX_NUMBER_OF_MEMBERS) {
            members[i]=newMember;
        } else {
            throw new IllegalStateException("Cannot add new member to team with maximum numbers of members");
        }
    }

    public Person[] getMembers() {
        return members;
    }

    @Override
    public Iterator createIterator() {
        return new TeamIterator(members);
    }
}