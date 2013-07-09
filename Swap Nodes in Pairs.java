/*
Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return head;
       
        ListNode node = head;
        ListNode prev = null;
       
        while (node != null && node.next != null) {
            ListNode nextNext = node.next.next;
            node.next.next = node;
            if (prev == null) {
                prev = node.next;
                head = node.next;
            } else {
                prev.next = node.next;
            }
            prev = node;
            node = nextNext;
        }
       
        if (node != null) {
            if (prev == null) {
                head = node;
            } else {
                prev.next = node;
            }
        } else {
            prev.next = null;
        }
        return head;
    }
}
