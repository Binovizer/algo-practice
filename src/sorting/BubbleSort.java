package sorting;

/**
 * The type BubbleSort
 *
 * @author Mohd Nadeem
 */
public class BubbleSort implements Sort{

    @Override
    public void sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i- 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
