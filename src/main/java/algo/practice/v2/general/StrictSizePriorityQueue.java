package algo.practice.v2.general;

import java.util.PriorityQueue;

public class StrictSizePriorityQueue<E> {
    private final PriorityQueue<E> queue;
    private final int maxSize;

    public StrictSizePriorityQueue(int maxSize) {
        this.queue = new PriorityQueue<>();
        this.maxSize = maxSize;
    }

    public boolean offer(E e) {
        if (queue.size() < maxSize) {
            return queue.offer(e);
        } else if (queue.size() == maxSize && queue.comparator().compare(e, queue.peek()) > 0) {
            queue.poll(); // Remove the least priority element
            return queue.offer(e);
        }
        return false;
    }

    public E poll() {
        return queue.poll();
    }

    public E peek() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }
}
