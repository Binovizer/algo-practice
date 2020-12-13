package algo.practice.v1.recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        int num = 12345;
        SumOfDigits sumOfDigits = new SumOfDigits();
        int sum = sumOfDigits.sum(num);
        System.out.println("sum = " + sum);
    }

    private int sum(int num) {
        if (num < 10) {
            return num;
        }
        return sum(num / 10) + (num % 10);
    }
}
