package linkedlist;

import utils.AssortedMethods;

/**
 * The type IsPallindrome
 *
 * @author Mohd Nadeem
 */
public class IsPallindrome {

    public boolean isPallindrome(LinkedListNode node){

        return false;
    }

    public static void main(String[] args) {
        LinkedListNode list = AssortedMethods.createLinkedListFromArray(new int[]{1, 2, 3, 2, 1});
        IsPallindrome isPallindrome = new IsPallindrome();
        isPallindrome.isPallindrome(list);
    }
}
