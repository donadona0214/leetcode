/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
       
        ListNode prev = null, head = null;
       
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
           
            if (prev == null) {
                head = node;
            } else {
                prev.next = node;
            }
           
            prev = node;
        }
       
        if (l1 != null) prev.next = l1;
        if (l2 != null) prev.next = l2;
        return head;
    }
}
