/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree {3,9,20,#,#,15,7},

    3   / \  9  20    /  \   15   7

return its level order traversal as:
[  [3],  [9,20],  [15,7]]
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null) return results;

        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        curr.add(root);
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
                vals.add(n.val);
            }
            results.add(vals);
            curr = next;
        }
        return results;
    }
}
