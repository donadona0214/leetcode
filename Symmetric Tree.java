/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1   / \  2   2 / \ / \3  4 4  3
But the following is not:
    1   / \  2   2   \   \   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
       
        return isSameTree(flipTree(root.left), root.right);
       
    }
   
    public TreeNode flipTree(TreeNode p) {
        if (p == null) return p;
       
        flipTree(p.left);
        flipTree(p.right);
       
        TreeNode n = p.left;
        p.left = p.right;
        p.right = n;
        return p;
    }
   
   
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
       
        if (p.val != q.val) return false;
       
        if (!isSameTree(p.left, q.left)) return false;
        if (!isSameTree(p.right, q.right)) return false; 
       
        return true;
    }
}
