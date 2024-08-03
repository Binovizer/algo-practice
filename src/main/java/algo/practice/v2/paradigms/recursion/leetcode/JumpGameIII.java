package algo.practice.v2.paradigms.recursion.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Desc : https://leetcode.com/problems/jump-game-iii/
 *
 * @author Nadeem 2020-11-28
 */
public class JumpGameIII {

    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 1, 2};
        int start = 2;

        JumpGameIII jumpGameIII = new JumpGameIII();
        boolean canReach = jumpGameIII.canReach(arr, start);
        System.out.println("canReach = " + canReach);
    }

    public boolean canReach(int[] arr, int start) {
        Set<Integer> traversedIndices = new HashSet<>();
        return canReach(arr, start, traversedIndices);
    }

    private boolean canReach(int[] arr, int index, Set<Integer> traversedIndices) {
        if (index < 0 || index >= arr.length || traversedIndices.contains(index)) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        traversedIndices.add(index);
        return canReach(arr, index + arr[index], traversedIndices)
                || canReach(arr, index - arr[index], traversedIndices);
    }
}
