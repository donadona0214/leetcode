/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height == null) return 0;
        int len = height.length;
        if (len == 0 || len == 1) return 0;
       
        int s = 0, e = len - 1;
        int maxArea = 0;
        while (s<e) {
            maxArea = Math.max(maxArea, Math.min(height[s], height[e]) * (e-s));
           
            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return maxArea;
    }
}
