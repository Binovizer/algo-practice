package arraysandstring;

import java.util.HashMap;
import java.util.Map;

/**
 * The type TwoSum
 *
 * @author Mohd Nadeem
 */
public class TwoSum {

    private int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(complement, i);
        }
        return new int[] {};
    }
}
