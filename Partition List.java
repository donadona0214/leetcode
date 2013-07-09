/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,

return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return head;
          ListNode smallHead = null, largeHead = null;
          ListNode smallPrev = null, largePrev = null;
         
          ListNode node = head;
         
          while(node != null) {
            if (node.val < x) {
                    if (smallHead == null) {
                         smallHead = node;
                    smallPrev = node;
                    } else {
                       smallPrev.next = node;
                    }
                    smallPrev = node;
               } else {
                    if (largeHead == null) {
                         largeHead = node;
                    largePrev = node;
                    } else {
                       largePrev.next = node;  
                    }
                    largePrev = node;                   
               }
              node = node.next;
           }
       
          if (smallHead != null) {
               if (largeHead != null) {
                     smallPrev.next = largeHead;
                    largePrev.next = null;
               } else {
                   smallPrev.next = null;
               }
          } else if (largeHead != null) {
             smallHead = largeHead;
             largePrev.next = null;
              
          }
         return smallHead;

    }
}
