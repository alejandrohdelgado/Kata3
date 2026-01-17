package software.ulpgc.kata3.viewmodel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram implements Iterable<Integer> {
    private final Map<Integer, Integer> histogram;

    public Histogram() {
        histogram = new HashMap<>();
    }

    public void add(int value) {
        histogram.put(value, count(value) + 1);
    }

    public Integer count(int value) {
        return histogram.getOrDefault(value, 0);
    }

    @Override
    public Iterator<Integer> iterator() {
        return histogram.keySet().iterator();
    }
    public int size(){
        return histogram.size();
    }

    public boolean isEmpty(){
        return histogram.isEmpty();
    }
}
