/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/

public class Solution {
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> swapPair = new Stack<TreeNode>();
        recoverTree(root, swapPair);
       
        if (swapPair.size() != 0) {
            TreeNode node1 = swapPair.pop();
            TreeNode node2 = swapPair.pop();
            int val = node1.val;
            node1.val = node2.val;
            node2.val = val;
        }
    }
       
    void recoverTree(TreeNode root, Stack<TreeNode> swapPair) {
        if (root == null) return;
        recoverTree(root.left, swapPair);
        addNodeToStack(swapPair, root);
        recoverTree(root.right, swapPair);
    }
   
    void addNodeToStack(Stack<TreeNode> swapPair, TreeNode root) {
        int sz = swapPair.size();
        if (sz == 0) {
            swapPair.push(root);
        } else if (sz == 1) {
            if (root.val >= swapPair.peek().val) {
                swapPair.pop();
            }
            swapPair.push(root);
        } else if (sz == 2) {
            if (root.val < swapPair.peek().val) {
                swapPair.pop();
                swapPair.push(root);
            }
        } 
    }
}
