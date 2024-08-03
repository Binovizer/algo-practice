package algo.practice.v1.arraysandstring;

/**
 * The type Multiply
 *
 * @author Mohd Nadeem
 */
public class Multiply {

    public static void main(String[] args) {
        String ans = Multiply.multiply("123", "345");
        System.out.println("ans = " + ans);
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        int index1 = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            int index2 = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + ans[index1 + index2] + carry;

                carry = sum / 10;
                ans[index1 + index2] = (sum % 10);
                index2++;
            }
            if (carry > 0) {
                ans[index1 + index2] += carry;
            }
            index1++;
        }
        int i = ans.length - 1;
        while (i >= 0 && ans[i] == 0) i--;

        if (i == -1) return "0";
        StringBuilder s = new StringBuilder();
        while (i >= 0) s.append(ans[i--]);
        return s.toString();
    }
}
