/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ]]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null) return result;
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        if (n == 0) return result;
      
        boolean[][] visited = new boolean[m][n];
        for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
                visited[p][q] = false;
            }
        }
      
        int[][] directions = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        int idx = 0;
      
        int i = 0, j = 0;
        result.add(matrix[i][j]);
        visited[i][j] = true;
      
        while (result.size() < m*n) {
            int ii = i + directions[idx][0];
            int jj = j + directions[idx][1];
          
            if ( ii >= 0 && ii < m && jj >= 0 && jj < n && !visited[ii][jj]) {
                i = ii;
                j = jj;
                result.add(matrix[i][j]);
                visited[i][j] = true;
            } else {
                idx = (idx + 1) % 4;
            }
        }
        return result;
    }
}
