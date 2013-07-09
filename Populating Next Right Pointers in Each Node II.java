/*
Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?
Note:
   * You may only use constant extra space.
For example,
Given the following binary tree,
         1       /  \      2    3     / \    \    4   5    7
After calling your function, the tree should look like:
         1 -> NULL       /  \      2 -> 3 -> NULL     / \    \    4-> 5 -> 7 -> NULL 
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
       
        ArrayList<TreeLinkNode> curr = new ArrayList<TreeLinkNode>();
        curr.add(root);
       
        while (!curr.isEmpty()) {
            ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
           
            for (int i = 0; i<curr.size(); i++) {
                TreeLinkNode node = curr.get(i);
                if (node.left != null) {
                   next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
                if (i != curr.size()-1) node.next = curr.get(i+1);
            }
            curr.get(curr.size()-1).next = null;
            curr = next;
        }
    }
}
