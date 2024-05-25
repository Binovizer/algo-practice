package algo.practice.v2.oj.leetcode.contests.W_396;

/**
 * The type A
 *
 * @author nadeem Date : 11/05/24
 */
public class A {

    public static void main(String[] args) {
        A a = new A();
        boolean uuE6 = a.isValid("UuE6");
        System.out.println("uuE6 = " + uuE6);
    }

    public boolean isValid(String word) {
        String vowels = "aeiouAEIOU";
        int vowelsCount = 0;
        int nonVowelsCount = 0;
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
            if (Character.isDigit(c)) continue;
            if (vowels.contains(c + "")) {
                vowelsCount++;
            } else {
                nonVowelsCount++;
            }
        }
        return vowelsCount != 0 && nonVowelsCount != 0 && word.length() >= 3;
    }
}
