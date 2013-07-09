/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || k <= 1) return head;
      
        ListNode prev = null;
        ListNode start = head, end = null;
        ListNode newHead = head;
      
        do {
            // find the end node of the loop
            int count = 1;
            end = start;
            while (end != null && count < k) {
                end = end.next;
                count ++;
            }
          
            // reverse from start to end if there is complete group
            if (end != null) {
                if (prev == null) {
                    newHead = end;
                } else {         
                    prev.next = end;
                }
               
                ListNode node = start;
                ListNode nextStart = end.next;
                prev = null;
                while (node != nextStart) {
                    ListNode nextNode = node.next;
                    node.next = prev;
                    prev = node;
                    node = nextNode;
                }
               
                prev = start;
                prev.next = nextStart;
                start = nextStart;
            }
        } while (start != null && end != null);
      
        return newHead;
    }
}
