/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int c = 0;
        int val = 0;
        ListNode head = null, result = null, prev = null;
        while (l1!= null || l2 != null) {
            int totalVal = c;
          
            if (l1 != null) {
                totalVal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                totalVal += l2.val;
                l2 = l2.next;
            }

            c = totalVal / 10;
            val = totalVal % 10;
          
            result = new ListNode(val);
            if (prev == null) {
                head = result;
            } else {
                prev.next = result;
            }

            prev = result;
        }
      
        if (c != 0) {
            result = new ListNode(c);
            prev.next = result;
        }
      
        return head;
    }
}
