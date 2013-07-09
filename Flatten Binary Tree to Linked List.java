/*
Given a binary tree, flatten it to a linked list in-place.
For example,
Given
         1        / \       2   5      / \   \     3   4   6
The flattened tree should look like:
   1    \     2      \       3        \         4          \           5            \             6
Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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
// a). forget the loss of right node, b) fail to clean up leftNode
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
       
        TreeNode prev = root;
        TreeNode rightNode = root.right;
        TreeNode leftNode = root.left;
        root.left = root.right = null;
        if (leftNode != null) {
            prev.right = leftNode;
            flatten(leftNode);
            while (prev.right != null) prev = prev.right;
        }
       
        if (rightNode != null) {
            prev.right = rightNode;
            flatten(rightNode);
        }
    }
}
