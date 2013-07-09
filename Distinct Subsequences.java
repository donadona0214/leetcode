/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of"ABCDE" while "AEC" is not).
Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
*/

public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (T == null) return 1;
        if (S == null) return 0;
       
        int lenS = S.length(), lenT = T.length();
        int[][] nums = new int[lenT+1][lenS+1];
        nums[0][0] = 1;
       
        for (int i = 1; i <= lenT; i++) nums[i][0] = 0;
        for (int j = 1; j <= lenS; j++) nums[0][j] = 1;
       
        for (int i = 1; i <= lenT; i++) {
            for (int j = 1; j <= lenS; j++) {
                if (T.charAt(i-1) != S.charAt(j-1)) {
                    nums[i][j] = nums[i][j-1];
                } else {
                    nums[i][j] = nums[i-1][j-1] + nums[i][j-1];
                }
            }
        }
        return nums[lenT][lenS];
    }
}
