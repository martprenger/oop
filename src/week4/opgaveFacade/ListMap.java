package week4.opgaveFacade;

import java.util.ArrayList;
import java.util.List;

public class ListMap<K,V> {
    List<K> ids = new ArrayList<>();
    List<V> members = new ArrayList<>();

    public void put(K key, V value) {
        if (ids.contains(key)) {
            members.set(ids.indexOf(key), value);
        } else {
            ids.add(key);
            members.add(value);
        }
    }
    public V get(K key) {
        if (!ids.contains(key)) {
            return null;
        }
        return members.get(ids.indexOf(key));
    }
}
