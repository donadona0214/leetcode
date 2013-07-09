/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree {3,9,20,#,#,15,7},
[  [3],  [20,9],  [15,7]]

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null) return results;

        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        curr.add(root);
        boolean flip = false;
        while(!curr.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<TreeNode>();
            ArrayList<Integer> vals = new ArrayList<Integer>();
            for (TreeNode n : curr) {
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
                if (flip) {
                    vals.add(0, n.val);
                } else {
                    vals.add(n.val);
                }
            }
            results.add(vals);
            curr = next;
            flip = ! flip;
        }
        return results;
    }
}
