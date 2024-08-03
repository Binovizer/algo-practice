package algo.practice.v2.general;

import java.util.Stack;

public class SlidingWindowMinStacks {
    private Stack<Integer> l, r;
    private int rMin;

    public SlidingWindowMinStacks() {
        l = new Stack<>();
        r = new Stack<>();
        rMin = Integer.MAX_VALUE;
    }

    public void pushBack(int x) {
        r.push(x);
        rMin = Math.min(rMin, x);
    }

    public void popFront() {
        if (l.isEmpty()) {
            int min = Integer.MAX_VALUE;
            while (!r.isEmpty()) {
                min = Math.min(min, r.peek());
                l.push(min);
                r.pop();
            }
            rMin = Integer.MAX_VALUE;
        }
        l.pop();
    }

    public int getMin() {
        int res = rMin;
        if (!l.isEmpty()) {
            res = Math.min(res, l.peek());
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMinStacks sw = new SlidingWindowMinStacks();
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
