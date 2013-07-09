/*
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1      / \     2   3 
Return 6.
*/

// corrected. 1. any node could be end node 2. value could be negative 3. How to deal with null child, should not considered in max_sum
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
    public class Result {
        public int maxValue;
        public int maxSum;
    }
   
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Result r = maxPathSumHelper(root);
       
        return r.maxSum;
    }
   
    public Result maxPathSumHelper(TreeNode root) {
        Result r = new Result();
       
        if (root == null) {
            r.maxValue = 0;
            r.maxSum = Integer.MIN_VALUE;
        } else if (root.left == null && root.right == null) {
            r.maxValue = root.val;
            r.maxSum = root.val;
        } else {
            Result lr = maxPathSumHelper(root.left);
            Result rr = maxPathSumHelper(root.right);
            int maxChild = Math.max(lr.maxValue, rr.maxValue);
           
            r.maxValue = root.val;
            if (maxChild > 0) r.maxValue += maxChild;
           
            int maxSum = Math.max(lr.maxSum, rr.maxSum);
            maxSum = Math.max(maxSum, r.maxValue);
            r.maxSum = Math.max(maxSum, lr.maxValue + rr.maxValue + root.val);
        } 
        return r;
    }
}
