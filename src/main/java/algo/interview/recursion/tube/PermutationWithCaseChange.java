package algo.interview.recursion.tube;

/**
 * This class helps generate permutations with case changes Problem Desc :
 * https://www.geeksforgeeks.org/permute-string-changing-case/
 *
 * @author Nadeem 2020-11-22
 */
public class PermutationWithCaseChange {

    public static void main(String[] args) {
        String str = "a1b2";
        PermutationWithCaseChange permutationWithCaseChange = new PermutationWithCaseChange();
        permutationWithCaseChange.generate(str);
    }

    /**
     * Generates permutations with case changes
     *
     * @param str the string
     */
    private void generate(String str) {
        generate(str, "");
    }

    /**
     * Generates permutations with input and out
     *
     * @param in the input
     * @param out the output
     */
    private void generate(String in, String out) {
        if (in.length() == 0) {
            System.out.println(out);
            return;
        }
        char currentChar = in.charAt(0);
        in = in.substring(1);
        String out1 = out + currentChar;
        generate(in, out1);
        boolean isDigit = Character.isDigit(currentChar);
        if (!isDigit) {
            String out2 = out + getChangedCaseSymbol(currentChar);
            generate(in, out2);
        }
    }

    /**
     * Changes the case of the symbol
     *
     * @param symbol the symbol
     * @return the changed case symbol
     */
    private char getChangedCaseSymbol(char symbol) {
        char changedSymbol;
        if (Character.isLowerCase(symbol)) {
            changedSymbol = Character.toUpperCase(symbol);
        } else {
            changedSymbol = Character.toLowerCase(symbol);
        }
        return changedSymbol;
    }
}
