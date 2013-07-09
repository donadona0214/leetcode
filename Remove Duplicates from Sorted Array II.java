/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A = [1,1,1,2,2,3],
Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length <= 1) return A.length;
      
        int s = 1;
        int e = 1;
        int dupCount =0;
        while (e<A.length) {
            if (A[e] != A[e-1]) {
                dupCount = 0;
            } else {
                dupCount ++;
            }
            if (dupCount >= 2) {
                e++;
                continue;
            }
            A[s++] = A[e++];
        }
        A = Arrays.copyOfRange(A, 0, s);
        return s;
    }
}
