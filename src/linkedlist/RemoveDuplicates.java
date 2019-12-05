package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * The type RemoveDuplicates
 *
 * @author Mohd Nadeem
 */
public class RemoveDuplicates {

    public void removeDuplicates(LinkedListNode head){
        Set<Integer> uniques = new HashSet<>();
        while(head != null){
            if(uniques.contains(head.data)){
                if(head.next != null){
                    head.next.setPrevious(head.prev);
                }
                head.prev.setNext(head.next);
            }else{
                uniques.add(head.data);
            }
            head = head.next;
        }
    }
}
