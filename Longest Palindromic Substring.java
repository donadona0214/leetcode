/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null) return s;
        int len = s.length();
        if (len == 0 || len == 1) return s;
       
        int[] maxLens = new int[len];
        maxLens[0] = 1;
        String maxString = s.substring(0, 1);

        for (int i = 1; i < len; i++) {
            maxLens[i] = maxLens[i-1];
            String sub = s.substring(i-maxLens[i-1], i+1);
            if (isPalindromic(sub)) {
                maxString = sub;
                maxLens[i] = maxLens[i-1] + 1;
            }
            if (i - 1 - maxLens[i-1] >=0) {
                sub = s.substring(i-maxLens[i-1]-1, i+1);
                if (isPalindromic(sub)) {
                    maxString = sub;
                    maxLens[i] = maxLens[i-1] + 2;
                }
            }
        }
        return maxString;
    }
   
    boolean isPalindromic (String s) {
        if (s == null) return true;
        int len = s.length();
        if (len == 0 || len == 1) return true;
        for (int i=0; i<len; i++) {
            if (s.charAt(i) != s.charAt(len-1-i)) return false;
        }
        return true;
    }
}
