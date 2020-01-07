package algo.misc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * The type LRUCache
 *
 * @author Mohd Nadeem
 */
public class LRUCacheOptimized {

    private static Entry defaultEntry = new Entry(-1, -1);

    private Deque<Entry> queue;
    private Map<Integer, Entry> map;
    private int capacity;

    public LRUCacheOptimized(int N) {
        capacity = N;
        queue = new ArrayDeque<>();
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCacheOptimized lruCache = new LRUCacheOptimized(3);
        lruCache.set(1, 1);
        printCache(lruCache);
        lruCache.set(2, 2);
        printCache(lruCache);
        lruCache.set(3, 3);
        printCache(lruCache);
        lruCache.set(4, 4);
        printCache(lruCache);
        lruCache.set(3, 3);
        printCache(lruCache);
        lruCache.set(2, 2);
        printCache(lruCache);
        lruCache.set(1, 1);
        printCache(lruCache);
    }

    private static void printCache(LRUCacheOptimized lruCache) {
        System.out.println("lruCacheQueue = " + lruCache.queue);
    }

    public int get(int x) {
        Entry orDefault = map.getOrDefault(x, defaultEntry);
        return orDefault.getValue();
    }

    public void set(int x, int y) {
        boolean hasKey = map.containsKey(x);
        if (hasKey) {
            Entry entry = map.get(x);
            queue.remove(entry);
            map.remove(x);
        } else {
            if (queue.size() == capacity) {
                Entry entry = queue.removeLast();
                map.remove(entry.getKey());
            }
        }
        Entry entry = new Entry(x, y);
        queue.offerFirst(entry);
        map.put(x, entry);
    }

    public static class Entry {
        private Integer key;
        private Integer value;

        public Entry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" + "key=" + key + ", value=" + value + '}';
        }
    }
}
