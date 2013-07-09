/*
Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.
[  [0,0,0],  [0,1,0],  [0,0,0]]
The total number of unique paths is 2.
Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
       
        int[][] paths = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) paths[i][n] = 0;
        for (int j = 0; j < n+1; j++) paths[m][j] = 0;
       
        for (int i = m-1; i>=0; i--) {
            for (int j = n-1; j>=0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                    continue;
                }
               
                if ( i == m-1 && j == n-1) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i+1][j] + paths[i][j+1];
                }
            }
        }
        return paths[0][0];
       
    }
}
