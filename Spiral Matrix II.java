/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
For example,
Given n = 3,
You should return the following matrix:[ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ]]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < n; q++) {
                matrix[p][q] = 0;
            }
        }
     
        int[][] directions = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        int idx = 0;
     
        int val = 1;
        int i = 0, j = 0;
        matrix[i][j] = val++;
     
        while (val <= n*n) {
            int ii = i + directions[idx][0];
            int jj = j + directions[idx][1];
         
            if ( ii >= 0 && ii < n && jj >= 0 && jj < n && matrix[ii][jj]==0) {
                i = ii;
                j = jj;
                matrix[i][j] = val++;
            } else {
                idx = (idx + 1) % 4;
            }
        }
        return matrix;     
    }
}
