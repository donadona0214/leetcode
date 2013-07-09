/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory. 
For example,
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length <= 1) return A.length;
       
        int s = 1;
        int e = 1;
        while (e<A.length) {
            if (A[e] != A[e-1]) {
                A[s++] = A[e];
            }
            e++;
        }
        return s;
    }
}
