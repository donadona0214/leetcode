/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Assume no duplicate values in lists
        if (lists == null || lists.isEmpty()) return null;
       
        Comparator<ListNode> comp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 0;
                }           
            }
        };
       
        Map<Integer, ListNode> nodeMap = new HashMap<Integer, ListNode>();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
            comp);
        for(ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
       
        ListNode prev = null, head = null;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (prev == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
           
            ListNode nextNode = node.next;
            if (nextNode != null) {
                pq.offer(nextNode);
            }
        }
        return head;
    }

}
