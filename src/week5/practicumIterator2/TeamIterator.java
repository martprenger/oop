package week5.practicumIterator2;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TeamIterator implements Iterator<Person>{
    private final Person[] members;
    private int curIndex;

    public TeamIterator(Person[] members) {
        this.members = members;
        this.curIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return curIndex < members.length && members[curIndex] != null;
    }

    @Override
    public Person next() {
        return members[curIndex++];
    }
}
