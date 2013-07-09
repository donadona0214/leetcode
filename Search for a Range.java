/*
Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,

return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ranges = new int[2];
        ranges[0] = -1;
        ranges[1] = -1;
      
        if (A == null) return ranges;
        int len = A.length;
        if (len == 0) return ranges;
      
        int s = 0, e = len -1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (A[mid] == target) {
                int minIdx = mid - 1;
                while (minIdx>=0 && A[minIdx] == target){
                    minIdx --;
                }
                ranges[0] = minIdx + 1;
              
                int maxIdx = mid + 1;
                while (maxIdx <len && A[maxIdx] == target) {
                    maxIdx ++;
                }
                ranges[1] = maxIdx - 1;
                return ranges;
            } else if (A[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ranges;
    }
}
