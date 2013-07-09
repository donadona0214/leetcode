/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
yes, 


Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] A, int target) {
        return searchHelper(A, 0, A.length-1, target);
    }
  
    public boolean searchHelper(int[] A, int s, int e, int target) {
        if (s > e) return false;
        int mid = s + (e-s)/2;
      
        if (target == A[mid]) return true;
       
        int rightMid = mid+1;
        if (A[mid] == A[e]) {
            while(rightMid <= e && A[rightMid] == A[mid]) rightMid ++;
        }
      
        if (A[mid] < A[e] || (A[mid] == A[e] && rightMid > e)) {
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
