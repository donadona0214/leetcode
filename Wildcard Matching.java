/*
Implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).The function prototype should be:bool isMatch(const char *s, const char *p)Some examples:isMatch("aa","a") ? falseisMatch("aa","aa") ? trueisMatch("aaa","aa") ? falseisMatch("aa", "*") ? trueisMatch("aa", "a*") ? trueisMatch("ab", "?*") ? trueisMatch("aab", "c*a*b") ? false
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s == null && p == null) return true;
        if (p == null || s == null) return false;
   
        int lenS = s.length(), lenP = p.length();
        if (lenS == 0 && lenP == 0) return true;
     
        if (lenP == 0) return false;
       
        ArrayList<String> patterns = getPatterns(p);
       
        // all string is "*"
        if (patterns.isEmpty()) return true;
       
        int start = 0;
        for (int i=0; i<patterns.size(); i++) {
            int pos = -1;
            if (i == patterns.size() -1 && (patterns.size() > 1 || p.charAt(0) == '*')) {
                pos = matchStrLast(s, patterns.get(i), start, lenS);
            } else {
                pos = matchStr(s, patterns.get(i), start, lenS);
            }
           
            if (pos == -1){
                return false;
            }
           
            if (i == 0 && p.charAt(0) != '*' && pos != 0) return false;
           
            start = pos + patterns.get(i).length();
        }
       
        if (start == lenS || p.charAt(lenP-1) == '*') return true;
        return false;
    }
   
    public int matchStr(String s, String p, int start, int end) {
        for (int pos = start; pos <= end - p.length(); pos ++) {
            boolean match = true;
            for (int i=0; i<p.length(); i++) {
                if (p.charAt(i) != '?' && p.charAt(i) != s.charAt(pos+i)) {
                    match = false;
                }
            }
           
            if (match) return pos;
        }
        return -1;
    }
   
    public int matchStrLast(String s, String p, int start, int end) {
        for (int pos = end - p.length(); pos >=start; pos--) {
            boolean match = true;
            for (int i=0; i<p.length(); i++) {
                if (p.charAt(i) != '?' && p.charAt(i) != s.charAt(pos+i)) {
                    match = false;
                }
            }
           
            if (match) return pos;
        }
        return -1;
    }
   
    public ArrayList<String> getPatterns(String p) {
        int s = 0;
        int len = p.length();
       
        ArrayList<String> patterns = new ArrayList<String>();
       
        for (int i=0; i<len; i++) {
            if (p.charAt(i) == '*') {
                if (s != i) {
                    patterns.add(p.substring(s, i));
                }
                s = i+1;
            }
        }
       
        if (s != len) {
            patterns.add(p.substring(s));
        }
        return patterns;
    }
}
