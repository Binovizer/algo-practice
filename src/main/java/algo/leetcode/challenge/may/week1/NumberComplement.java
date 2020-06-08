package algo.leetcode.challenge.may.week1;

public class NumberComplement {

    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }

    public static void main(String[] args) {
        int num = 5;
        NumberComplement numberComplement = new NumberComplement();
        int complement = numberComplement.findComplement(num);
        System.out.println("complement = " + complement);
    }
}
