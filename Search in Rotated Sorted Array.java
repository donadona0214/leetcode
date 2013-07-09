/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1. 
You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return searchHelper(A, 0, A.length-1, target);
    }
   
    public int searchHelper(int[] A, int s, int e, int target) {
        if (s > e) return -1;
        int mid = s + (e-s)/2;
       
        if (target == A[mid]) return mid;
       
        if (A[mid] < A[e]) {
            if (target > A[mid] && target <= A[e]) {
                return searchHelper(A, mid+1, e, target);
            } else {
                return searchHelper(A, s, mid-1, target);
            }
        } else {
            if (target >=A[s] && target < A[mid]) {
                return searchHelper(A, s, mid-1, target);
            } else {
                return searchHelper(A, mid+1, e, target);
            }
        }
    }
}
