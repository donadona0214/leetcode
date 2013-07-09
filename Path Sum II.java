/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return pathSumHelper(root, new ArrayList<Integer>(), sum);
    }
   
    public ArrayList<ArrayList<Integer>> pathSumHelper(TreeNode root, ArrayList<Integer> path, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root == null) return paths;
        int remain = sum - root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            paths.add(path);
            return paths;
        }
       
        if (root.left != null) {
            ArrayList<Integer> leftPath = (ArrayList<Integer>) path.clone();
            paths.addAll(pathSumHelper(root.left, leftPath, remain));
        }
       
        if (root.right != null) {
            ArrayList<Integer> rightPath = (ArrayList<Integer>) path.clone();
            paths.addAll(pathSumHelper(root.right, rightPath, remain));
        }
       
        return paths;
    }
}
