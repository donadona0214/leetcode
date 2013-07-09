/*
The n-queens puzzle is the problem of placing n queens on an n�n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:
[ [".Q..",  // Solution 1  "...Q",  "Q...",  "..Q."], ["..Q.",  // Solution 2  "Q...",  "...Q",  ".Q.."]] 
*/

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> results = new ArrayList<String[]>();
        if (n <= 0) return results;
       
        int[] cols = new int[n];
        return solveNQueensHelper(cols, n, 0);
    }
   
    public ArrayList<String[]> solveNQueensHelper(int[] cols, int n, int k) {
        ArrayList<String[]> results = new ArrayList<String[]>();
        if (k == n) {
            String[] result= new String[n];
            for (int i = 0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j<n; j++) {
                    if (j == cols[i]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                result[i] = sb.toString();
            }
            results.add(result);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(cols, k, i)) {
                    cols[k] = i;
                    results.addAll(solveNQueensHelper(cols, n, k+1));
                }
            }
        }
        return results;
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

