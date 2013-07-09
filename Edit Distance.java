/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character

c) Replace a character
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1 == null && word2 == null) return 0;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();
       
        int len1 = word1.length(), len2 = word2.length();
       
        int[][] dists = new int[len1+1][len2+1];
       
        for (int i = 0; i < len1 + 1; i++) {
            dists[i][0] = i;
        }
       
        for (int j = 0; j < len2 + 1; j++) {
            dists[0][j] = j;
        }
       
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int minDist = Math.min(dists[i-1][j] + 1, dists[i][j-1] + 1);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    minDist = Math.min(minDist, dists[i-1][j-1]);
                } else {
                    minDist = Math.min(minDist, dists[i-1][j-1]+1);
                }
                dists[i][j] = minDist;
            }
        }
       
        return dists[len1][len2];
    }  
}
