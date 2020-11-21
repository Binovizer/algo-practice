package algo.interview.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * This class helps find the power set of a string
 *
 * @author Nadeem 2020-11-21
 */
public class UniquePowerSet {

    public static void main(String[] args) {
        String input = "aab";
        String output = "";
        UniquePowerSet powerSet = new UniquePowerSet();
        Set<String> uniquePowerSet = new HashSet<>();
        powerSet.solve(uniquePowerSet, input, output);
        System.out.println("uniquePowerSet = " + uniquePowerSet);
    }


    private void solve(Set<String> uniquePowerSet, String input, String output) {
        if (input.length() == 0) {
            uniquePowerSet.add(output);
            return;
        }
        String op2 = output + input.charAt(0); // Selecting the current symbol
        input = input.substring(1); // Small the input by removing the current processed symbol
        solve(uniquePowerSet, input, output);
        solve(uniquePowerSet, input, op2);
    }
}
