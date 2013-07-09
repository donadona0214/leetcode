/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (grid == null) return 0;
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
       
        int[][] minPaths = new int[m][n];
       
        minPaths[m-1][n-1] = grid[m-1][n-1];
        for (int i = m-2; i >= 0; i--) {
            minPaths[i][n-1] = grid[i][n-1] + minPaths[i+1][n-1];
        }
       
        for (int j = n-2; j >= 0; j--) {
            minPaths[m-1][j] = grid[m-1][j] + minPaths[m-1][j+1];
        }
       
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                minPaths[i][j] = grid[i][j] + Math.min(minPaths[i+1][j], minPaths[i][j+1]);
            }
        }
        return minPaths[0][0];
    }
}
