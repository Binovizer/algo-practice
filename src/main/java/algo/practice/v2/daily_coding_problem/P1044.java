package algo.practice.v2.daily_coding_problem;

import java.util.*;

/**
 * The type P1044
 *
 * @author nadeem Date : 05/06/24
 */
public class P1044 {

    private static final Set<Character> DELIMITERS =
            new HashSet<>(Arrays.asList(' ', ',', '.', ';', ':','/'));

    public static void main(String[] args) {
        P1044 p1044 = new P1044();
        String reversed = p1044.reverse("/hello/world:here/");
        System.out.println(reversed);
    }

    public String reverse(String input) {
        if (input == null || input.isEmpty()) return input;

        List<String> delimiters = new ArrayList<>();
        Stack<String> words = new Stack<>();

        parseInput(input, delimiters, words);
        return buildReversedString(input, delimiters, words);
    }

    private void parseInput(String input, List<String> delimiters, Stack<String> words) {
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (DELIMITERS.contains(c)) {
                delimiters.add(extractDelimiters(input, i));
                i += delimiters.get(delimiters.size() - 1).length();
            } else {
                words.push(extractWord(input, i));
                i += words.peek().length();
            }
        }
    }

    private String extractDelimiters(String input, int start) {
        StringBuilder delimiters = new StringBuilder();
        while (start < input.length() && DELIMITERS.contains(input.charAt(start))) {
            delimiters.append(input.charAt(start));
            start++;
        }
        return delimiters.toString();
    }

    private String extractWord(String input, int start) {
        StringBuilder word = new StringBuilder();
        while (start < input.length() && !DELIMITERS.contains(input.charAt(start))) {
            word.append(input.charAt(start));
            start++;
        }
        return word.toString();
    }

    private String buildReversedString(String input, List<String> delimiters, Stack<String> words) {
        StringBuilder result = new StringBuilder();
        boolean startsWithDelimiter = DELIMITERS.contains(input.charAt(0));
        int delimiterIndex = 0;

        while (delimiterIndex < delimiters.size() || !words.isEmpty()) {
            if (startsWithDelimiter && delimiterIndex < delimiters.size()) {
                result.append(delimiters.get(delimiterIndex++));
                startsWithDelimiter = false;
            } else if (!words.isEmpty()) {
                result.append(words.pop());
                startsWithDelimiter = true;
            }
        }
        return result.toString();
    }
}
