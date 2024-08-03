package algo.practice.v2.oj.leetcode.challenges.dec.week2;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-10
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        ValidMountainArray validMountainArray = new ValidMountainArray();
        boolean isValid = validMountainArray.isValid(arr);
        System.out.println("isValid = " + isValid);
    }

    private boolean isValid(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        boolean up = true;
        for (int i = 1; i < arr.length; i++) {
            if (up) {
                if (arr[i] < arr[i - 1]) {
                    if (i == 1) {
                        return false;
                    }
                    up = false;
                } else if (arr[i] == arr[i - 1]) {
                    return false;
                }
            } else {
                if (arr[i] >= arr[i - 1]) {
                    return false;
                }
            }
        }
        return !up;
    }
}
