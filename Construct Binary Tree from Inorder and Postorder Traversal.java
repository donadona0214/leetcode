/*
Given inorder and postorder traversal of a tree, construct the binary tree.
Note:

You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
      
        if (inorder == null || postorder == null) return null;
        if (inorder.length != postorder.length) return null;
      
        int len = inorder.length;
        if (len == 0) return null;
      
        int val = postorder[len - 1];
        TreeNode node = new TreeNode(val);
        int i;
        for (i=0; i<len; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
      
        if (i == len) return null;
        if (i-1>=0) {
            node.left = buildTree(Arrays.copyOfRange(inorder,0,i),
                Arrays.copyOfRange(postorder,0, i));
        }
       
        if (i+1 < len) {
            node.right = buildTree(Arrays.copyOfRange(inorder,i+1,len),
                Arrays.copyOfRange(postorder,i, len-1));
        }
        return node;
    }
}
