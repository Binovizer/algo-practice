package algo.practice.v2.general;

/**
 * The type DiskSpaceAnalysis
 *
 * @author nadeem Date : 28/07/24
 */
import java.util.*;

public class DiskSpaceAnalysis {

    public static int segment(int x, int[] space) {
        // Deque to store indices of array elements
        Deque<Integer> deque = new LinkedList<>();
        int maxOfMins = Integer.MIN_VALUE;

        for (int i = 0; i < space.length; i++) {
            // Remove elements from the back of the deque if they are greater than
            // the current element (maintaining the min element at the front)
            while (!deque.isEmpty() && space[deque.peekLast()] >= space[i]) {
                deque.pollLast();
            }

            // Add the current element at the back of the deque
            deque.addLast(i);

            // Remove elements from the front of the deque if they are out of the current window
            if (deque.peekFirst() <= i - x) {
                deque.pollFirst();
            }

            // Start to consider elements only when we have at least x elements processed
            if (i >= x - 1) {
                // The element at the front of the deque is the minimum in the current window
                int currentMin = space[deque.peekFirst()];
                // Update the maximum of the minimums found
                maxOfMins = Math.max(maxOfMins, currentMin);
            }
        }

        return maxOfMins;
    }

    public static void main(String[] args) {
        int[] space = {2, 8, 4, 6};
        int x = 2;
        System.out.println(segment(x, space)); // Output: 4
    }
}
