/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pos = 0;
        if (A == null) return pos;
        int len = A.length;
        if (len == 0) return pos;
     
        int s = 0, e = len -1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
