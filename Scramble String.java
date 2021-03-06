/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of s1 = "great":
    great   /    \  gr    eat / \    /  \g   r  e   at           / \          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.
For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
    rgeat   /    \  rg    eat / \    /  \r   g  e   at           / \          a   t
We say that "rgeat" is a scrambled string of "great".
Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string"rgtae".
    rgtae   /    \  rg    tae / \    /  \r   g  ta  e       / \      t   a
We say that "rgtae" is a scrambled string of "great".
Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) return false;
       
        if (len1 == 1) return s1.charAt(0) == s2.charAt(0);
       
        for (int i = 1; i < len1; i++) {
            String ls1 = s1.substring(0,i), rs1 = s1.substring(i);
            String ls2 = s2.substring(0,i), rs2 = s2.substring(i);
            String l2s2 = s2.substring(0, len1 -i), r2s2 = s2.substring(len1-i);
           
            if((isAnagram(ls1, ls2) && isAnagram(rs1, rs2) && isScramble(ls1, ls2) && isScramble(rs1, rs2)) ||
                (isAnagram(ls1, r2s2) && isAnagram(rs1, l2s2) && isScramble(ls1, r2s2) && isScramble(rs1, l2s2))) {
                return true;
            }
        }
        return false;
    }

    boolean isAnagram(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) return false;
        int[] histo = new int[26];
        for (int i = 0; i< 26; i++) histo[i] = 0;
        for (int i = 0; i< len1; i++) {
            histo[s1.charAt(i)-'a'] ++;
            histo[s2.charAt(i)-'a'] --;
        }
       
        for (int i = 0; i< 26; i++) {
            if (histo[i] != 0) return false;
        }
        return true;
    }
}
