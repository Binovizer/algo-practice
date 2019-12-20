package arraysandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The type IntersectionOfTwoArrays
 *
 * @author Mohd Nadeem
 */
public class IntersectionOfTwoArrays {

  public static void main(String[] args) {
    int[] num1 = {4, 9, 5};
    int[] num2 = {9, 4, 9, 8, 4};
    IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
    int[] intersect = intersectionOfTwoArrays.intersect(num1, num2);
    System.out.println("intersect = " + Arrays.toString(intersect));
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (int value : nums1) {
      if (map.containsKey(value)) map.put(value, map.get(value) + 1);
      else map.put(value, 1);
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
}
