package algo.practice.v1.arraysandstring;

/**
 * The type PallindromePermutation
 *
 * @author Mohd Nadeem
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        boolean isPermutation = palindromePermutation.isPermutation("bcaca");
        System.out.println("isPermutation = " + isPermutation);
    }

    public boolean isPermutation(String string) {
        String lowerCaseString = string.toLowerCase();
        int[] count = new int[256];
        for (int i = 0; i < lowerCaseString.length(); i++) {
            char c = lowerCaseString.charAt(i);
            if (c == ' ') {
                continue;
            }
            int val = c - 'a';
            ++count[val];
        }
        boolean alreadyOdd = false;
        for (int i : count) {
            boolean isOdd = (i & 1) == 1;
            if (isOdd) {
                if (alreadyOdd) {
                    return false;
                }
                alreadyOdd = true;
            }
        }
        return true;
    }
}
