/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
       
        int a = 1, b = 2;
       
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = a+b;
            a = tmp;
        }
        return b;
    }
}
