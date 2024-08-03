package algo.practice.v2.general;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMinDeque {
    private Deque<int[]> deque;
    private int l, r;

    public SlidingWindowMinDeque() {
        deque = new LinkedList<>();
        l = r = 0;
    }

    public void pushBack(int x) {
        while (!deque.isEmpty() && deque.getLast()[0] >= x) {
            deque.removeLast();
        }
        deque.addLast(new int[]{x, r});
        r++;
    }

    public void popFront() {
        if (!deque.isEmpty() && deque.getFirst()[1] == l) {
            deque.removeFirst();
        }
        l++;
    }

    public int getMin() {
        return deque.isEmpty() ? Integer.MAX_VALUE : deque.getFirst()[0];
    }

    public static void main(String[] args) {
        SlidingWindowMinDeque sw = new SlidingWindowMinDeque();
        int[] nums = {2, 3, 1, 5, 4, 8, 7, 6, 9};
        int k = 3;
        
        for (int i = 0; i < nums.length; i++) {
            sw.pushBack(nums[i]);
            if (i >= k - 1) {
                System.out.println("Minimum in window [" + (i - k + 1) + ", " + i + "]: " + sw.getMin());
                sw.popFront();
            }
        }
    }
}
