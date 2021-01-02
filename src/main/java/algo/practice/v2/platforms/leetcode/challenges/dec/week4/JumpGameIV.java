package algo.practice.v2.platforms.leetcode.challenges.dec.week4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-28
 */
public class JumpGameIV {

    public static void main(String[] args) {
        int[] arr = {
            80, -86, 40, 12, 40, -98, 12, -86, -79, -4, -79, 71, 44, -43, -9, -88, 88, -43, 31, 4,
            71, -86, 55, -9, -65
        };
        JumpGameIV jumpGameIV = new JumpGameIV();
        int minJumps = jumpGameIV.minJumps(arr);
        System.out.println("minJumps = " + minJumps);
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            List<Integer> indices = map.get(curr);
            if (Objects.isNull(indices)) {
                indices = new ArrayList<>();
            }
            indices.add(i);
            map.put(curr, indices);
        }
        Set<Integer> traversedIndices = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(arr[0]);
        return minJumps(arr, 0, 0, arr.length - 1, traversedIndices, q, map);
    }

    private int minJumps(
            int[] arr,
            int steps,
            int currIndex,
            int n,
            Set<Integer> traversedIndices,
            Queue<Integer> q,
            Map<Integer, List<Integer>> map) {
        if (currIndex == n) {
            return steps;
        }
        List<Integer> indices = map.get(arr[currIndex]);
        int min = Integer.MAX_VALUE;
        if (indices.size() > 1) {
            for (int index : indices) {
                if (!traversedIndices.contains(index)) {
                    traversedIndices.add(index);
                    min =
                            Math.min(
                                    min,
                                    minJumps(arr, steps + 1, index, n, traversedIndices, q, map));
                }
            }
        }
        int op1 = Integer.MAX_VALUE;
        if (currIndex + 1 <= n) {
            traversedIndices.add(currIndex + 1);
            op1 = minJumps(arr, steps + 1, currIndex + 1, n, traversedIndices, q, map);
        }
        int op2 = Integer.MAX_VALUE;
        if (currIndex - 1 >= 0) {
            traversedIndices.add(currIndex - 1);
            op2 = minJumps(arr, steps + 1, currIndex - 1, n, traversedIndices, q, map);
        }
        return Math.min(min, Math.min(op1, op2));
    }
}
