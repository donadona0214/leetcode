/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region .
For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X 
*/

public class Solution { 
    public void fill(char[][] board, int m, int n, int i, int j,
        Stack<List<Integer>> fill, Set<List<Integer>> visited) {
        if (i<0 || i>m-1 || j<0 || j>n-1) return;
        List<Integer> index = Arrays.asList(i, j);
       
        if(board[i][j]=='O' && !visited.contains(index)) {
            fill.push(index);
            visited.add(index);
        }
    }
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length, n;
        if (m == 0) return;
        n = board[0].length;
        if (m == 1 || n == 1) return;
      
        Stack<List<Integer>> fill = new Stack<List<Integer>>();
        Set<List<Integer>> visited = new HashSet<List<Integer>>();
      
        for (int i=0; i<m; i++) {
            fill(board, m, n, i, 0, fill, visited);
            fill(board, m, n, i, n-1, fill, visited);
        }
      
        for (int j=1; j<n-1; j++) {
            fill(board, m, n, 0, j, fill, visited);
            fill(board, m, n, m-1, j, fill, visited);
        }
      
        while (!fill.empty()) {
            List<Integer> index = fill.pop();
           
            int x = index.get(0);
            int y = index.get(1);
           
            fill(board, m, n, x-1, y, fill, visited);
            fill(board, m, n, x+1, y, fill, visited);
            fill(board, m, n, x, y-1, fill, visited);
            fill(board, m, n, x, y+1, fill, visited);
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O' && !visited.contains(Arrays.asList(i, j))) {
                    board[i][j]='X';
                }
            }
        }
        return;
    }
}
