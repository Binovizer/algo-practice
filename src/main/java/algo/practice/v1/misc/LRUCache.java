package algo.practice.v1.misc;

import java.util.HashMap;

class Entry {
    int key;
    int value;
    Entry prev;
    Entry next;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private HashMap<Integer, Entry> map;
    private Entry head;
    private Entry tail;
    private int capacity;

    public LRUCache(int size) {
        capacity = size;
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache(4);
        lrucache.put(1, 1);
        lrucache.put(10, 15);
        lrucache.put(15, 10);
        lrucache.put(10, 16);
        lrucache.put(12, 15);
        lrucache.put(18, 10);
        lrucache.put(13, 16);

        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Entry entry = new Entry(key, value);
        if (map.containsKey(key)) {
            entry = map.get(key);
            entry.value = value;
            removeNode(entry);
        } else {
            if (map.size() > capacity) {
                map.remove(tail.key);
                removeNode(tail);
            }
            map.put(key, entry);
        }
        addAtTop(entry);
    }

    public void addAtTop(Entry node) {
        node.next = head;
        node.prev = null;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = head;
    }

    public void removeNode(Entry node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }
}
