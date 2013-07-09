/*
Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"

Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
 
        int lenA = a.length(), lenB = b.length();
        int minLen = Math.min(lenA, lenB);
        Integer c = 0, sum = 0;
        for (int i=0; i<minLen; i++) {
            c = addBinaryHelper(sb, a.charAt(lenA-i-1), b.charAt(lenB-i-1), c);
        }
      
        while (lenA > minLen) {
            c = addBinaryHelper(sb, a.charAt(lenA - minLen -1), '0', c);
            minLen ++;
        }
      
        while (lenB > minLen) {
            c = addBinaryHelper(sb, b.charAt(lenB - minLen -1), '0', c);
            minLen ++;
        }
      
        if (c != 0) sb.insert(0, (char)(c + '0'));
      
        return sb.toString();
    }
   
    public int addBinaryHelper(StringBuilder sb, char a, char b, int c) {
        int sum = 0;
        sum += a - '0';
        sum += b - '0';
        sum += c;
      
        c = sum / 2;
        sb.insert(0, (char)(sum%2 + '0'));
        return c;
    }
}
