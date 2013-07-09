/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example:
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null) return -1;
        int len = A.length;
        if (len == 0) return -1;
        if (len == 1) return 0;
       
        List<Integer> reached = new ArrayList<Integer>();
        reached.add(0);
        int max = A[0];
        int count = 1;
       
        boolean bUpdate = false;
        if (A[0] != 0) bUpdate = true;
       
        while (bUpdate) {
            if (max >= len -1) break;
           
            bUpdate = false;
            List<Integer> newReached = new ArrayList<Integer>();
           
            for (Integer idx : reached) {
                for (int i = idx+1; i <= idx+A[idx]; i++) {
                    if (i + A[i] > max) {
                        max = i + A[i];
                        bUpdate = true;
                        newReached.add(i);
                    }
                }

            } 
            reached = newReached;
            count ++;
        }
       
        if (max >= len-1) return count;
       
        return -1;
    }
}
