package algo.practice.v1.misc;

public class NumbersWithNDigitAndDigitSumS {

    private static int count;

    public static void main(String[] args) {
        int n = 6;
        int sum = 7;
        NumbersWithNDigitAndDigitSumS numbersWithNDigitAndDigitSumS =
                new NumbersWithNDigitAndDigitSumS();
        numbersWithNDigitAndDigitSumS.findNumbers(n, sum);
        System.out.println(count);
    }

    public void findNumbers(int n, int sum) {
        count = 0;
        findNumbersUtil(n, sum, "");
    }

    private void findNumbersUtil(int n, int rem, String num) {
        if (rem < 0) {
            return;
        }
        if (num.length() == n) {
            if (rem == 0) {
                count++;
                System.out.println(num);
            }
            return;
        }
        int start = 0;
        if (num.length() == n - 1) {
            start = 1;
        }
        for (int i = start; i <= 9; i++) {
            num = i + num;
            findNumbersUtil(n, rem - i, num);
            num = num.substring(1);
        }
    }
}
