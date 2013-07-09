/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
For example,
Given:
s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.

When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1 == null && s2 == null && s3 == null) return true;
        if (s3 == null) return false;
        if (s1 == null) return s3.equals(s2);
        if (s2 == null) return s3.equals(s1);
      
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][] IL = new boolean[len1+1][len2+1];
        for (int i=0; i<=len1; i++) {
            for (int j=0; j<=len2; j++) {
                if (i==0 && j==0) {
                    IL[i][j] = true;
                } else if (i==0) {
                    IL[i][j] = IL[i][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
                } else if (j==0) {
                    IL[i][j] = IL[i-1][j] && (s1.charAt(i-1) == s3.charAt(i-1));
                } else {
                    IL[i][j] = (IL[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1))) ||
                        (IL[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)));
                }
            }
        }
        return IL[len1][len2];
    }
}
