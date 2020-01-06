package arraysandstring;

/**
 * The type CheckPermutation
 *
 * @author Mohd Nadeem
 */
public class CheckPermutation {

    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();
        boolean isPermutation = checkPermutation.checkPermutation("aacd", "dcaa");
        System.out.println("isPermutation = " + isPermutation);
    }

    public boolean checkPermutation(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 != length2) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < length1; i++) {
            int val = str1.charAt(i);
            ++count[val];
        }
        for (int i = 0; i < length2; i++) {
            int val = str2.charAt(i);
            --count[val];
            if (count[val] < 0) {
                return false;
            }
        }
        return true;
    }
}
