/*
Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.
Questions:
1. Do we have a range of values
*/

// bugs a) founds[i-1]=true; b) boolean[] founds = new founds[len];
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null) return 1;
       
        int len = A.length;
        if (len == 0) return 1;
       
        boolean[] founds = new boolean[len];
        for (int i = 0; i < len; i++) {
            founds[i] = false;
        }
       
        for (int i = 0; i < len; i++) {
            if (A[i] > 0 && A[i] <=len) founds[A[i]-1] = true;
        }
       
        for (int i = 0; i < len; i++) {
            if (!founds[i]) return i+1;
        }
       
        return len + 1;
    }
}
