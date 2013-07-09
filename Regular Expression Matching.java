/*
Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character. '*' Matches zero or more of the preceding element. The matching should cover the entire input string (not partial). The function prototype should be: bool isMatch(const char *s, const char *p) Some examples: isMatch("aa","a") ? false isMatch("aa","aa") ? true isMatch("aaa","aa") ? false isMatch("aa", "a*") ? true isMatch("aa", ".*") ? true isMatch("ab", ".*") ? true isMatch("aab", "c*a*b") ? true 
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null && p == null) return true;
        if (p == null || s == null) return false;
       
        int lenS = s.length(), lenP = p.length();
        if (lenS == 0 && lenP == 0) return true;
       
        if (lenP > 1 && p.charAt(1) == '*') {
            int i = -1;
            do {
                if (isMatch(s.substring(i+1), p.substring(2))) {
                    return true;
                }
                i ++;
            } while (i < lenS &&
                (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.'));
        }
       

        if (lenP == 0 || lenS == 0) return false;
       
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            return isMatch(s.substring(1), p.substring(1));
        }
       
        return false;
       
    }
}
