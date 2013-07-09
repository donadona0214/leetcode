/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1   / \  2   3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> numbers = findNumbers(root, 0);
        int sum = 0;
        for(Integer number : numbers) sum += number;
        return sum;
    }
  
    public ArrayList<Integer> findNumbers(TreeNode node, int parent) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        if (node == null) return numbers;
      
        int curr = parent * 10 + node.val;
      
        if (node.left == null && node.right == null) numbers.add(curr);
      
        ArrayList<Integer> leftNumbers = findNumbers(node.left, curr);
        ArrayList<Integer> rightNumbers = findNumbers(node.right, curr);
        numbers.addAll(leftNumbers);
        numbers.addAll(rightNumbers);
        return numbers;
    }
}
