/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
*/


public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (n <= 0) {
            ArrayList<TreeNode> results = new ArrayList<TreeNode>();
            results.add(null);
            return results;
        }
       
        int[] vals = new int[n];
        for (int i=0; i< n; i++) vals[i] = i+1;
        return generateTreesHelper(vals, 0, n-1);
    }

    public ArrayList<TreeNode> generateTreesHelper(int[] vals, int i, int j) {
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        if (i>j) return results;
        for (int k = i; k <= j; k++) {
            ArrayList<TreeNode> left = generateTreesHelper(vals, i, k-1);
            ArrayList<TreeNode> right = generateTreesHelper(vals, k+1, j);
            for (int m = 0; m < Math.max(left.size(),1); m ++) {
                for (int n = 0; n < Math.max(right.size(), 1); n++) {
                    TreeNode node = new TreeNode(vals[k]);
                    if (left.size() > 0) {
                        node.left = left.get(m);
                    }
                   
                    if (right.size() > 0) {
                        node.right = right.get(n);
                    }
                    results.add(node);
                }
            }
        }
        return results;
    }
}
