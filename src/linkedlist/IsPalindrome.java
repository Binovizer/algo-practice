package linkedlist;

import utils.AssortedMethods;

/**
 * The type IsPalindrome
 *
 * @author Mohd Nadeem
 */
public class IsPalindrome {

  public static void main(String[] args) {
    LinkedListNode list = AssortedMethods.createLinkedListFromArray(new int[] {1, 2, 3, 2, 1});
    IsPalindrome isPalindrome = new IsPalindrome();
    boolean palindrome = isPalindrome.isPalindrome(list);
    System.out.println("palindrome = " + palindrome);
  }

  public boolean isPalindrome(LinkedListNode node) {

    return false;
  }
}
