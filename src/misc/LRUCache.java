package misc;

import java.util.*;

/**
 * The type LRUCache
 *
 * @author Mohd Nadeem
 */
public class LRUCache {

    private Deque<Integer> queue;
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int N) {
        capacity = N;
        queue = new ArrayDeque<>();
        map = new HashMap<>();
    }

    public int get(int x) {
        return map.getOrDefault(x, -1);
    }

    public void set(int x, int y) {
        boolean hasKey = map.containsKey(x);
        if(hasKey){
            Iterator<Integer> iterator = queue.iterator();
            while(iterator.hasNext()) {
                Integer next = iterator.next();
                if(next == x){
                    queue.remove();
                    map.remove(x);
                }
            }
        } else {
            if(queue.size() == capacity){
                queue.removeLast();
            }
        }
        queue.offerFirst(x);
        map.put(x, y);
    }

    public static void main(String[] args) {

    }
}
