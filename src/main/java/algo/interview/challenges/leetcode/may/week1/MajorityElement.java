package algo.interview.challenges.leetcode.may.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * MajorityElement helps find the majority element in an array. The majority element is the element
 * that appears more than <b>⌊ n/2 ⌋</b> times. <a
 * href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/">Majority
 * Element</a>
 *
 * @author Nadeem 2020-06-08 3:55 PM
 */
public class MajorityElement {

    public int majorityElement(int[] numbers) {
        Map<Integer, Integer> map = countNumbers(numbers);
        int majorityElement = -1;
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value > numbers.length / 2) {
                majorityElement = key;
            }
        }
        return majorityElement;
    }

    private Map<Integer, Integer> countNumbers(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 2, 1, 1, 1, 2, 2};
        MajorityElement majorityElement = new MajorityElement();
        int element = majorityElement.majorityElement(numbers);
        System.out.println("majorityElement = " + element);
    }
}
