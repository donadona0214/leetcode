/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s = "aab",

Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null) return 0;
        int len = s.length();
     
        int[] minCuts = new int[len+1];
        boolean[][] palin = new boolean[len][len];
       
        minCuts[0] = -1;
        for (int i=0; i<len; i++) {
            minCuts[i+1] = i;
            palin[i][i] = true;
        }
       
        for (int i=1; i<len; i++) {
            for (int j=0; j<=i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j<2 || palin[i-1][j+1])) {
                    palin[i][j] = true;
                    minCuts[i+1] = Math.min(minCuts[i+1], minCuts[j] + 1);
                }
            }
        }
        return minCuts[len];
    }
}
