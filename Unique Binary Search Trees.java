/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.
*/

public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n < 0) return 0;
        if (n == 0 || n==1) return 1;
       
        int[] nums = new int[n+1];
        nums[0] = nums[1] = 1;
        for (int i = 2; i<= n; i++) {
            int num = 0;
            for (int j=1; j<=i; j++) {
                num += nums[j-1]*nums[i-j];
            }
            nums[i] = num;
        }
        return nums[n];
    }
}
