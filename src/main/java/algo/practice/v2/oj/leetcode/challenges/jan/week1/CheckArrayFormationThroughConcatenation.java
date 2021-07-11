package algo.practice.v2.oj.leetcode.challenges.jan.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2021-01-02
 */
public class CheckArrayFormationThroughConcatenation {

    public static void main(String[] args) {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        CheckArrayFormationThroughConcatenation checkArrayFormationThroughConcatenation =
                new CheckArrayFormationThroughConcatenation();
        boolean canFormArray = checkArrayFormationThroughConcatenation.canFormArray(arr, pieces);
        System.out.println("canFormArray = " + canFormArray);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            indexMap.put(pieces[i][0], i);
        }
        int i = 0;
        while (i < arr.length) {
            int curr = arr[i];
            if (indexMap.containsKey(curr)) {
                Integer index = indexMap.get(curr);
                for (int j = 0; j < pieces[index].length; j++) {
                    if (pieces[index][j] != arr[i]) {
                        return false;
                    }
                    i++;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
