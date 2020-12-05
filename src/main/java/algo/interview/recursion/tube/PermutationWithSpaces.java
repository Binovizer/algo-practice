package algo.interview.recursion.tube;

/**
 * This class helps generate all permutations with spaces of a string Desc :
 * https://practice.geeksforgeeks.org/problems/permutation-with-spaces/0
 *
 * @author Nadeem 2020-11-22
 */
public class PermutationWithSpaces {

    public static void main(String[] args) {
        String str = "ABC";
        PermutationWithSpaces permutationWithSpaces = new PermutationWithSpaces();
        permutationWithSpaces.generate(str);
    }

    /**
     * Generates the all permutations with space of a string
     *
     * @param str the string
     */
    private void generate(String str) {
        generate(str, "");
    }

    /**
     * Generates using the input and output
     *
     * @param in the input
     * @param out the output
     */
    private void generate(String in, String out) {
        if (in.length() == 1) {
            System.out.println(out + in);
            return;
        }
        String out1 = out + in.charAt(0) + "";
        String out2 = out + in.charAt(0) + " ";
        in = in.substring(1);
        generate(in, out1);
        generate(in, out2);
    }
}
