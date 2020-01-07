package algo.arraysandstring;

import java.util.*;

/**
 * The type IntersectionOfTwoArrays
 *
 * @author Mohd Nadeem
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        //        int[] intersect = intersectionOfTwoArrays.intersect(num1, num2);
        int[] intersect = intersectionOfTwoArrays.intersectUnique(num1, num2);
        System.out.println("intersect = " + Arrays.toString(intersect));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int value : nums1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (int value : nums2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                result.add(value);
                map.put(value, map.get(value) - 1);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    public int[] intersectUnique(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        for (int value : nums1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (int value : nums2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                result.add(value);
                map.put(value, map.get(value) - 1);
            }
        }
        int[] arr = new int[result.size()];
        int i = 0;
        for (int e : result) {
            arr[i++] = e;
        }
        return arr;
    }
}
