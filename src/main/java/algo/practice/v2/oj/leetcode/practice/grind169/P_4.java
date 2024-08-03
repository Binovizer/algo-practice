package algo.practice.v2.oj.leetcode.practice.grind169;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The type P_4
 *
 * @author nadeem Date : 20/07/24
 */
public class P_4 {
    /**
     * Adds elements from the array to the heaps and balances the heaps.
     *
     * @param nums the array of integers to add to the heaps
     * @param maxHeap the max-heap to store the smaller half of the elements
     * @param minHeap the min-heap to store the larger half of the elements
     */
    public void addToHeap(
            int[] nums, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        for (int num : nums) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Balance the heaps if necessary
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    /**
     * Finds the median of two sorted arrays.
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return the median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements of both arrays to the heaps
        addToHeap(nums1, maxHeap, minHeap);
        addToHeap(nums2, maxHeap, minHeap);

        int totalLength = nums1.length + nums2.length;

        // Calculate the median based on the total length
        if (totalLength % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        P_4 solution = new P_4();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(
                "Median: " + solution.findMedianSortedArrays(nums1, nums2)); // Should print 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(
                "Median: " + solution.findMedianSortedArrays(nums3, nums4)); // Should print 2.5
    }
}
