/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle

[     [2],    [3,4],   [6,5,7],  [4,1,8,3]]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/


public class Solution { 
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Use DFS to calculate the min path
        int depth = triangle.size();
        if (depth == 0) return 0;
       
        int[] minSums = new int[depth];
        for (int i = 0; i < triangle.get(depth-1).size(); i++) {
            minSums[i] = triangle.get(depth-1).get(i);
        }
       
        for (int d = depth - 2; d >= 0; d--) {
            for (int i = 0; i < triangle.get(d).size(); i++) {
                minSums[i] = triangle.get(d).get(i)
                    + Math.min(minSums[i], minSums[i+1]);
            }
        }
       
        return minSums[0];
    }
}
