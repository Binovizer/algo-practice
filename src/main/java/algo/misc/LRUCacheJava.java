package algo.misc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type LRUJava
 *
 * @author Mohd Nadeem
 */
public class LRUCacheJava<K, V> extends LinkedHashMap<K, V> {

    private Integer capacity;

    public LRUCacheJava(Integer capacity) {
        super(capacity * 4 / 3, 0.75f);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
