/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null) return 0;
        int len = A.length;
        if (len <= 2) return 0;
       
        int[] heights = Arrays.copyOfRange(A, 0, len);
        Arrays.sort(heights);      
        int sum = 0;
        for (int i=1; i <len; i ++) {
            int val = heights[i];
            int diff = heights[i] - heights[i-1];
            int s = 0, e = len - 1;
            while (A[s] < val && s<len) s++;
            while (A[e] < val && e>=0) e--;
          
            for (; s<e; s++) {
                if (A[s] < val) sum += diff;
            }
        }
        return sum;
    }
}
