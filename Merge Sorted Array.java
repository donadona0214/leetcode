/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.
Note:

You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

// Boundary conditions to stop at idx >=0 instead of idx >0
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int idxA = m - 1;
        int idxB = n - 1;
        int idx = m + n - 1;
       
        while (idxA >= 0 && idxB >= 0) {
            if (A[idxA] > B[idxB]) {
                A[idx--] = A[idxA--];
            } else {
                A[idx--] = B[idxB--];
            }
        }
       
        while (idxA>=0) A[idx--] = A[idxA--];
        while (idxB>=0) A[idx--] = B[idxB--];
    }
}
