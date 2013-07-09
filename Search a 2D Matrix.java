/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
   * Integers in each row are sorted from left to right.
   * The first integer of each row is greater than the last integer of the previous row.
For example,
Consider the following matrix:
[  [1,   3,  5,  7],  [10, 11, 16, 20],  [23, 30, 34, 50]]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
       
        int i = 0, j = n -1;
        while (i < m && j>=0) {
            if (matrix[i][j] == target) return true;
           
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
       
        return false;
    }
}

