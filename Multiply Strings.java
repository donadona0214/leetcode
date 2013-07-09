/*
Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
*/

// Bugs: for from large to small still use i++, not update len1 after swap; not correct order for num2 **** StringBuilder to insert int value, directly use the number, it will switch to char. 
public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String result = "";
        if (num1 == null || num2 == null) return result;
        int len1 = num1.length(), len2 = num2.length();
        if (len1 == 0 ||len2 == 0) return result;
      
        // Swap the string
        if (len1 < len2) {
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
            len1 = num1.length();
            len2 = num2.length();
        }
       
        result = "0";
        for (int i = len2-1; i>=0; i--) {
            String subResult = multiplyHelper(num1, num2.charAt(i));
            result = Add(result, subResult);
            num1 += "0";
        }
      
        return result;
    }
  
    public String multiplyHelper(String num1, char num2) {
        StringBuilder sb = new StringBuilder();
        if (num2 == '0') return "0";
      
        int n2 = num2 - '0';
        int c = 0;
        for (int i=num1.length() -1; i>=0; i--) {
            int n1 = num1.charAt(i) - '0';
            int val = n1 * n2 + c;
            sb.insert(0, val % 10);
            c = val / 10;
        }
      
        if (c != 0) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
  
    public String Add(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int len = Math.max(len1, len2);
      
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = 0; i < len; i++) {
            int val = c;
            if (i<len1) {
                val += num1.charAt(len1-1-i) - '0';
            }
            if (i<len2) {
                val += num2.charAt(len2-1-i) - '0';
            }
            sb.insert(0, val % 10);
            c = val / 10;
        }
      
        if (c != 0) {
            sb.insert(0, c);
        }
      
        return sb.toString();
    }
}
