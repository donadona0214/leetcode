/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.

Given 1->1->2->3->3, return 1->2->3.
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
        while (curr != null) {
            while ((curr.next != null) && curr.val == curr.next.val) {
                curr = curr.next;
            }
           
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
