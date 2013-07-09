/*
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || n < 0) return head;
        ListNode prev= null, last = null;
        ListNode curr = head, fast = head;
       
        int nLen = 0;
        while (curr != null) {
            last = curr;
            curr = curr.next;
            nLen ++;
        }
       
        n = n%nLen;
        if (n == 0) return head;
       
        while (n>0) {
            fast = fast.next;
            n--;
        }
       
        curr = head;
        while (fast != null) {
            prev = curr;
            fast = fast.next;
            curr = curr.next;
        }
       
        last.next = head;
        prev.next = null;

        return curr;
    }
}

