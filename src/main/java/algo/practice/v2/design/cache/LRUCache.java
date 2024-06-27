package algo.practice.v2.design.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type LRUSimple <a href="https://leetcode.com/problems/lru-cache/">...</a>
 *
 * @author nadeem Date : 09/05/24
 */
class LRUCache {

    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map =
                new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry eldest) {
                        return this.size() > capacity;
                    }
                };
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
