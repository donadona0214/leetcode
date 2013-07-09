/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs == null) return "";
        int numStrs = strs.length;
        if (numStrs == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (int i=0; i<numStrs; i++) {
            if (strs[i].length() < minLen) minLen = strs[i].length();
        }

        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < numStrs; j++) {
                if (strs[j].charAt(i) != c) {
                   return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,minLen);
    }
}
