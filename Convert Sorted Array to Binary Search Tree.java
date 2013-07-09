/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null) return null;
        return sortedArrayToBSTHelper(num, 0, num.length-1);
    }
   
    public TreeNode sortedArrayToBSTHelper(int[] num, int i, int j) {
        if (i>j) return null;
       
        int mid = (i+j)/2;
       
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTHelper(num, i, mid-1);
        root.right = sortedArrayToBSTHelper(num, mid+1, j);
        return root;
    }
}
