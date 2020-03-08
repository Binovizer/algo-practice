package algo.arraysandstring;

public class GivenSumWithAdditionAndSubtraction {

    public static void main(String[] args) {
        int[] arr = {-3, 1, 3, 5};
        int sum = 6;
        GivenSumWithAdditionAndSubtraction givenSumWithAdditionAndSubtraction =
                new GivenSumWithAdditionAndSubtraction();
        int totalWays = givenSumWithAdditionAndSubtraction.findTotalWays(arr, sum);
        System.out.println("totalWays = " + totalWays);
    }

    private int findTotalWays(int[] arr, int sum) {
        return findTotalWaysUtil(arr, 0, sum);
    }

    private int findTotalWaysUtil(int[] arr, int index, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (index >= arr.length) {
            return 0;
        }
        return findTotalWaysUtil(arr, index + 1, sum)
                + findTotalWaysUtil(arr, index + 1, sum + arr[index])
                + findTotalWaysUtil(arr, index + 1, sum - arr[index]);
    }
}
