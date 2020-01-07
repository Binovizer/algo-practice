package algo.arraysandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Leaders
 *
 * @author Mohd Nadeem
 */
public class Leaders {

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        Leaders leaders = new Leaders();
        List<Integer> l = leaders.findLeaders(arr);
        System.out.println("leaders = " + l);
    }

    private List<Integer> findLeaders(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int leader = arr[n - 1];
        list.add(leader);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                leader = arr[i];
                list.add(leader);
            }
        }
        return list;
    }
}
