package software.ulpgc.kata3.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram implements Iterable<Integer> {
    private final Map<Integer, Integer> map;

    public Histogram() {
        this.map = new HashMap<>();
    }

    public void add(Integer bin) {
        map.put(bin, count(bin) + 1);
    }

    public Integer count(Integer bin) {
        return map.getOrDefault(bin, 0);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }


    @Override
    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }
}
