package dp;

/**
 * The type CoinChange
 *
 * @author Mohd Nadeem
 */
public class CoinChange {

    public int possibleSolutions(int[] arr, int n){
        return count(arr, arr.length, n);
    }

    private int count(int[] arr, int m, int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if (m <= 0) {
            return 0;
        }
        return count(arr, m - 1, n) + count(arr, m, n - arr[m-1]);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        CoinChange coinChange = new CoinChange();
        int count = coinChange.possibleSolutions(arr, 7);
        System.out.println("count = " + count);
    }
}
