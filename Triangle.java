/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle

[     [2],    [3,4],   [6,5,7],  [4,1,8,3]]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
    public class Node {
        public int x, y, total;
      
        public Node(int x, int y, int total) {
            this.x = x;
            this.y = y;
            this.total = total;
        }
    }
  
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Use DFS to calculate the min path
        Stack<Node> s = new Stack<Node>();
        if (triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return Integer.MIN_VALUE;
        }
      
        int depth = triangle.size();
        s.push(new Node(0,0, triangle.get(0).get(0)));
        int minTotal = Integer.MAX_VALUE;
        while (!s.isEmpty()) {
            Node node = s.pop();
            if (node.x >= depth -1 ) {
                if (minTotal > node.total) minTotal = node.total;
            } else {
                int x = node.x, y = node.y, total = node.total;
                Node left = new Node(x+1, y, total + triangle.get(x+1).get(y));
                Node right = new Node(x+1, y+1, total + triangle.get(x+1).get(y+1));
                s.push(right);
                s.push(left);
            }
        }
        return minTotal;
    }
}
