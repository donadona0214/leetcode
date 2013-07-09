/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example, 
Given s = "Hello World",

return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null) return 0;
        int len = s.length();
        if (len == 0) return 0;
        int count = 0;
       
        boolean last = true;
        for (int i = len-1; i>=0; i--) {
            if (last && s.charAt(i) == ' ') continue;
            if (!last && s.charAt(i) == ' ') break;
            last = false;
            count ++;
        }
        return count;
    }
}
