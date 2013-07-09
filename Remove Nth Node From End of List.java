/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.  
   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || n<=0) return head;
       
        ListNode prev = head;
        ListNode first = head;
        ListNode second = head;
        int count = 1;
     
        while (count < n && first != null) {
            first = first.next;
            count++;
        }
       
        if (first == null) return head;

        while (first.next != null) {
            prev = second;
            first = first.next;
            second = second.next;
        }
       
        if (prev == second) return head.next;
        prev.next = second.next;
        return head;
    }
}
