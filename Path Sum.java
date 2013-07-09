/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return hasPathSumHelper(root, sum);
    }
   
    public boolean hasPathSumHelper(TreeNode root, int sum) {
        if (root == null) return false;
       
        int remain = sum - root.val;
        if (root.left == null && root.right == null && remain == 0) {
            return true;
        }
      
        if (root.left != null && hasPathSumHelper(root.left, remain)) {
            return true;
        }
      
        if (root.right != null && hasPathSumHelper(root.right, remain)) {
            return true;
        }
        return false;
    }
}
