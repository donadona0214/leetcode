/*
Implement strStr().
Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) {           
            if(needle == null || needle.length() == 0) {
                return "";
            } else {
                return null;
            }
        }
        boolean found;
        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            found = true;
            for (int j=0; j<needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    found = false;
                }
            }
           
            if (found) return haystack.substring(i);
        }
        return null;
    }
}
