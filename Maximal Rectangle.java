/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null) return 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
       
       
        int[] sum = new int[n];
       
        for (int j = 0; j < n; j++) sum[j] = 0;
       
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    sum[j] = 0;
                } else {
                    sum[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(sum));
        }
        return maxArea;
    }
   
   
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height == null) return 0;
        int len = height.length;
        if (len == 0) return 0;
        if (len == 1) return height[0];
      
        int mid = len / 2;
      
        int leftArea = largestRectangleArea(Arrays.copyOfRange(height, 0, mid));
        int rightArea = largestRectangleArea(Arrays.copyOfRange(height, mid, len));
      
        int maxArea = Math.max(leftArea, rightArea);
      
        int s = mid - 1, e = mid;
      
        int min = Integer.MAX_VALUE;
      
        while (s >= 0 && e < len) {
            min = Math.min(min, height[s]);
            min = Math.min(min, height[e]);
          
            int area = (e - s + 1) * min;
            if (area > maxArea) maxArea = area;
          
            int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
            if (s-1>=0) left = height[s-1];
            if (e+1<len) right = height[e+1];
          
            if (left >= right) s--;
            if (left <= right) e++;
        }
        return maxArea;
    }
}
