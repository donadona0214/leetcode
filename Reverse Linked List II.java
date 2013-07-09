/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:

1 ? m ? n ? length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || m==n) return head;
        int count = 1;
        ListNode node = head;
        ListNode prev = head;
        while (count < m && node!= null) {
            prev = node;
            node = node.next;
            count ++;
        }
      
        if (node != null) {
            ListNode start = node;
            ListNode prev2 = null;
            ListNode nextNode = node.next;
            while (count <= n && node != null) {
                nextNode = node.next;
                node.next = prev2;
                prev2 = node;
                node = nextNode;
                count ++;
            }
            start.next = nextNode;
          
            if (prev == start) {
                head = prev2;
            } else {
                prev.next = prev2;
            }
          
        }
      
        return head;
    }
}
