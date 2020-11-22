package algo.interview.recursion;

/**
 * This class helps find the power set of a string
 *
 * @author Nadeem 2020-11-21
 */
public class PowerSet {

    public static void main(String[] args) {
        String input = "abc";
        String output = "";
        PowerSet powerSet = new PowerSet();
        powerSet.solve(input, output);
    }

    /**
     * Prints the power set of a string
     *
     * @param input the input
     * @param output the output
     */
    private void solve(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        String op2 = output + input.charAt(0); // Selecting the current symbol
        input = input.substring(1); // Small the input by removing the current processed symbol which is at index 0
        solve(input, output); // Recurse with not selecting the current symbol
        solve(input, op2); // Recurse with selecting current symbol
    }
}
