package algo.interview.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class sorts the given array or list
 *
 * @author Nadeem 2020-10-25
 */
public class SortList {

    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 5, 4};
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        SortList sortList = new SortList();
        sortList.sort(list);
        System.out.println("list = " + list);
    }

    private void sort(List<Integer> list) {
        // Base Case
        if(list.size() == 1){
            return;
        }
        // Hypothesis + Induction
        int remaining = list.remove(list.size()-1);
        sort(list);
        insert(list, remaining);
    }

    public void insert(List<Integer> list, int element) {
        // Base Case
        if (list.size() == 0 || list.get(list.size() - 1) <= element) {
            list.add(element);
            return;
        }
        // Hypothesis + Induction
        int remaining = list.remove(list.size() - 1);
        insert(list, element);
        list.add(remaining);
    }
}
