package algo.misc;

import java.util.*;

/**
 * The type LRUCache
 *
 * @author Mohd Nadeem
 */
public class LRUCacheBasic {

    private Deque<Integer> queue;
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCacheBasic(int N) {
        capacity = N;
        queue = new ArrayDeque<>();
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCacheBasic lruCacheBasic = new LRUCacheBasic(3);
        lruCacheBasic.set(1, 1);
        lruCacheBasic.set(2, 2);
        lruCacheBasic.set(3, 3);
        lruCacheBasic.set(4, 4);
        printCache(lruCacheBasic);
        lruCacheBasic.set(3, 3);
        printCache(lruCacheBasic);
        lruCacheBasic.set(2, 2);
        printCache(lruCacheBasic);
        lruCacheBasic.set(1, 1);
        printCache(lruCacheBasic);
    }

    private static void printCache(LRUCacheBasic lruCacheBasic) {
        System.out.println("lruCacheQueue = " + lruCacheBasic.queue);
        System.out.println("lruCacheMap = " + lruCacheBasic.map);
    }

    public int get(int x) {
        return map.getOrDefault(x, -1);
    }

    public void set(int x, int y) {
        boolean hasKey = map.containsKey(x);
        if (hasKey) {
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == x) {
                    iterator.remove();
                    map.remove(x);
                }
            }
        } else {
            if (queue.size() == capacity) {
                Integer key = queue.removeLast();
                map.remove(key);
            }
        }
        queue.offerFirst(x);
        map.put(x, y);
    }
}
