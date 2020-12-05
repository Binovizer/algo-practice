package algo.interview.recursion.gfg;

/**
 * This class decodes the string as per the given format Problem Desc :
 * https://practice.geeksforgeeks.org/problems/decode-the-string/0/
 *
 * @author Nadeem 2020-11-23
 */
public class DecodeString {

    public static void main(String[] args) {
        String encodedString = "3[b3[ca]]";
        DecodeString decodeString = new DecodeString();
        String decodedString = decodeString.decode(encodedString);
        System.out.println("decodedString = " + decodedString);
    }

    /**
     * Decodes the string
     *
     * @param input the input
     * @return the decoded string
     */
    private String decode(String input) {
        if (!input.contains("[")) {
            return input;
        }
        int openBracketIndex = input.indexOf("[");
        int closedBracket = getCloseBracketIndex(input);
        String remaining = input.substring(0, openBracketIndex);
        input = input.substring(openBracketIndex + 1, closedBracket);
        String output = decode(input);
        return decodeRemaining(remaining, output);
    }

    /**
     * Decode the remaining
     *
     * @param remaining the remaining string
     * @param output the output
     * @return the string
     */
    private String decodeRemaining(String remaining, String output) {
        if (remaining.isEmpty()) {
            return output;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < remaining.length(); i++) {
            if (Character.isDigit(remaining.charAt(i))) {
                break;
            } else {
                sb.append(remaining.charAt(i));
            }
        }
        int repetitionCount = getRepetitionCount(remaining);
        for (int i = 0; i < repetitionCount; i++) {
            sb.append(output);
        }
        return sb.toString();
    }

    /**
     * Get repetition count
     *
     * @param remaining the remaining
     * @return the count
     */
    private int getRepetitionCount(String remaining) {
        StringBuilder sb = new StringBuilder();
        for (int i = remaining.length() - 1; i >= 0; i--) {
            if (Character.isDigit(remaining.charAt(i))) {
                sb.insert(0, remaining.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * Get close bracket index
     *
     * @param input the input
     * @return the close bracket index
     */
    private int getCloseBracketIndex(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == ']') {
                return i;
            }
        }
        return -1;
    }
}
