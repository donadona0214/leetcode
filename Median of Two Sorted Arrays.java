/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if ((m + n)%2 == 0) {
            return ((double) findkthSortedArrays(A, B, (m+n)/2)
            + (double) findkthSortedArrays(A, B, (m+n-1)/2))/2;
        } else {
            return findkthSortedArrays(A, B, (m+n)/2);
        }
   }

   public double findkthSortedArrays(int A[], int B[], int k) {
       if (A == null || A.length == 0) return B[k];
       if (B == null || B.length == 0) return A[k];
       if (k == 0) {
         return A[k] <= B[k] ? A[k] : B[k];
       }
      
       int m = A.length, n = B.length;
       int i = m*k/(m+n);
       int j = k -1 - i;
      
       if (A[i] >= B[j]) {
          if (j+1==n || A[i] <= B[j+1]) {
            return A[i];
          } else {
            // drop the first j elements in B
            return findkthSortedArrays(A, Arrays.copyOfRange(B,j+1, n), k-1-j);
          }
       } else {
          if (i+1==m || B[j] <= A[i]) {
            return B[j];
          } else {
            // drop the first i elements in A
            return findkthSortedArrays(Arrays.copyOfRange(A, i+1, m), B, k-1-i);
          }
       }
   }
}
