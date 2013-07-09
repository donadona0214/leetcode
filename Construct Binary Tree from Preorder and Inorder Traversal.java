/*
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:

// buggy with copyOfRange index - upper parameter is not included, function call error
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
     
        if (inorder == null || preorder == null) return null;
        if (inorder.length != preorder.length) return null;
    
        int len = inorder.length;
        if (len == 0) return null;
    
        int val = preorder[0];
        TreeNode node = new TreeNode(val);
      
        int i;
        for (i=0; i<len; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
    
        if (i == len) return null;
       
        if (i-1 >= 0) {
                node.left = buildTree(Arrays.copyOfRange(preorder,1, i+1),
                Arrays.copyOfRange(inorder,0,i));
        }
        if (i+1 < len) {
            node.right = buildTree(Arrays.copyOfRange(preorder,i+1, len),
            Arrays.copyOfRange(inorder,i+1,len));
        }
        return node;
    }
}
