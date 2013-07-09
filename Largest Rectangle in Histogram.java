/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
For example,
Given height = [2,1,5,6,2,3],

return 10.
*/

public class Solution {
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
