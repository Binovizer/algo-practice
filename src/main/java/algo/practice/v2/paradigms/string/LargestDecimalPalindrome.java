package algo.practice.v2.paradigms.string;

/**
 * The type LargestDecimalPalindrome
 *
 * @author nadeem Date : 08/06/24
 */
public class LargestDecimalPalindrome {

    public static void main(String[] args) {
        LargestDecimalPalindrome largestDecimalPalindrome = new LargestDecimalPalindrome();
        String largestPalindrome = largestDecimalPalindrome.largestPalindrome("0000");
        System.out.println("largestPalindrome = " + largestPalindrome);
    }

    private String largestPalindrome(String str) {
        int[] freq = new int[10];
        for (char c : str.toCharArray()) {
            freq[c - '0']++;
        }

        StringBuilder left = new StringBuilder();
        String center = "";
        StringBuilder right = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && left.toString().isEmpty()) {
                continue;
            }
            while (freq[i] > 1) {
                left.append(i);
                right.insert(0, i);
                freq[i] -= 2;
            }
            if (freq[i] != 0 && center.isEmpty()) {
                center = i + "";
            }
        }
        String ans = left + center + right;
        return ans.isEmpty() ? "0" : ans;
    }
}
