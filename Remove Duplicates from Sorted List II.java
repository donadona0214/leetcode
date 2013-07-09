/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given 1->2->3->3->4->4->5, return 1->2->5.

Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) return head;
       
        ListNode curr = head;
       
        ListNode newHead = null, newCurr = null;
        boolean isDuplicate = false;
        while (curr != null) {

            while ((curr.next != null)) {
                if (curr.val != curr.next.val && !isDuplicate) break;
               
                if (curr.val == curr.next.val) {
                    isDuplicate = true;
                } else if (isDuplicate) {
                    isDuplicate = false;
                }
               
                curr = curr.next;
            }
            if (isDuplicate) break;
           
            if (newHead == null) {
                newHead = curr;
                newCurr = curr;
            } else {
                newCurr.next = curr;
                newCurr = curr;
            }
           
            curr = curr.next;
        }
        if (newCurr != null) newCurr.next = null;
        return newHead;
    }
}
