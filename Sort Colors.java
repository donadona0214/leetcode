/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null) return;
        int len = A.length;
        if (len == 0) return;
       
        int nColors = 3;
       
        int[] hists = new int[nColors];
       
        for (int i=0; i<len; i++) {
            hists[A[i]] ++;
        }
       
        int pos = 0;
        for (int i=0; i< nColors; i++) {
            for(int j=0; j<hists[i]; j++) {
                A[pos++] = i;
            }
        }
    }
}
