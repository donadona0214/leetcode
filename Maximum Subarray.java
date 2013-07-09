/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null) return 0;
       
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<A.length; i++) {
            sum += A[i];
           
            if (sum > maxSum) maxSum = sum;
           
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
}
