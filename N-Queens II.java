/*
Follow up for N-Queens problem.
The n-queens puzzle is the problem of placing n queens on an n�n chessboard such that no two queens attack each other.
Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
   public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0) return 0;
       
        int[] cols = new int[n];
        return solveNQueensHelper(cols, n, 0);
    }
   
    public int solveNQueensHelper(int[] cols, int n, int k) {
        int sum = 0;
        if (k == n) {
            sum = 1;
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(cols, k, i)) {
                    cols[k] = i;
                    sum += solveNQueensHelper(cols, n, k+1);
                }
            }
        }
        return sum;
    }
   
    public boolean isValid(int[] cols, int k, int i) {
        for (int m = 0; m < k; m ++) {
            if (cols[m] == i) return false;
            if (m + cols[m] == k + i) return false;
            if (m - cols[m] == k - i) return false;
        }
        return true;
    }
}
