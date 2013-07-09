/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A sudoku puzzle is a grid of nine by nine squares or cells. 
The objective of sudoku is to enter a digit from 1 through 9 in each cell, in such a way that:
  Each horizontal row (shown in pink) contains each digit exactly once
  Each vertical column (shown in yellow) contains each digit exactly once
  Each subgrid or region (shown in green) contains each digit exactly once
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board == null) return true;
        int m = board.length;
        if (m == 0) return true;
        int n = board[0].length;
        if (n == 0) return true;
       
        int len = Math.max(m, 9);
        char[] array = new char[len];
       
        for (int i=0; i<m; i++) {
            if (!isValidSudokuHelper(board[i], n)) return false;
        }
       
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                array[j] = board[j][i];
            }
            if (!isValidSudokuHelper(array, m)) return false;
        }
       
        for (int i=0; i<m-2; i += 3) {
            for(int j=0; j<n-2; j += 3) {
                int k=0;
                for(int p=0; p<3; p++) {
                    for (int q=0; q<3; q++) {
                        array[k++] = board[j+q][i+p];
                    }
                }
                if (!isValidSudokuHelper(array, 9)) return false;
            }
        }
        return true;
    }
   
    public boolean isValidSudokuHelper(char[] array, int len) {
        boolean[] hits = new boolean[10];
        for (int i=0; i<len; i++) {
            if (array[i] != '.') {
                int val = array[i] - '0';
                if (hits[val]) return false;
                hits[val] = true;
            }
        }
        return true;
    }
}
