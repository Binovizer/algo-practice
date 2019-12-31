package backtracking;

/**
 * The type SubsetSum
 *
 * @author Mohd Nadeem
 */
public class SubsetSum {

    private static int count = 0;
    private static int[] visited;

    public void solve(int[] arr, int sum) {
        visited = new int[arr.length];
        //        boolean solve = solve(arr, visited, 0, sum);
        //        if(solve){
        //            printSolution(arr);
        //        }else{
        //            System.out.println("No solution exist.");
        //        }
        //        solveAll(arr, visited, 0, 0, sum);
        solveAll(arr, visited, 0, 0, sum);
    }

    private void printSolution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == 1) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private boolean solve(int[] arr, int[] visited, int currSum, int sum) {
        if (currSum == sum) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isSafe(arr, i, currSum, sum)) {
                visited[i] = 1;
                if (solve(arr, visited, currSum + arr[i], sum)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }

    private void solveAll(int[] arr, int[] visited, int currSum, int index, int sum) {
        if (currSum == sum) {
            System.out.println("Solution # " + ++count);
            printSolution(arr);
            visited[index] = 0;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (isSafe(arr, i, currSum, sum)) {
                visited[i] = 1;
                solveAll(arr, visited, currSum + arr[i], i, sum);
                visited[i] = 0;
            }
        }
    }

    private void solveAll(int[] arr, int[] visited, int currSum, int sum) {
        if (currSum == sum) {
            System.out.println("Solution # " + ++count);
            printSolution(arr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isSafe(arr, i, currSum, sum)) {
                visited[i] = 1;
                solveAll(arr, visited, currSum + arr[i], sum);
                visited[i] = 0;
            }
        }
    }

    private boolean isSafe(int[] arr, int i, int currSum, int sum) {
        return (i >= 0 && i < arr.length && visited[i] != 1 && currSum + arr[i] <= sum);
    }
}
