package algo.arraysandstring;

/**
 * The type PermutationOfString
 *
 * @author Mohd Nadeem
 */
public class PermutationOfString {

    public static void main(String[] args) {
        PermutationOfString permutationOfString = new PermutationOfString();
        permutationOfString.permute("ABC");
    }

    public void permute(String str) {
        int n = str.length();
        permuteUtil(str.toCharArray(), 0, n - 1);
    }

    private void permuteUtil(char[] str, int l, int r) {
        if (l == r) {
            System.out.println(String.valueOf(str));
        } else {
            for (int i = l; i <= r; i++) {
                swap(str, l, i);
                permuteUtil(str, l + 1, r);
                swap(str, l, i);
            }
        }
    }

    private void swap(char[] str, int l, int i) {
        char temp = str[l];
        str[l] = str[i];
        str[i] = temp;
    }
}
