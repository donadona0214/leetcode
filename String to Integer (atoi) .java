/*
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str == null || str.isEmpty()) return 0;
      
        long val = 0;
        boolean first = true;
        boolean firstSpace = true;
        int sign = 1;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && firstSpace) {
               continue;
            }
           
            firstSpace = false;
           
            if (first && (c == '-' || c == '+')) {
               if (c == '-') sign = -1;
               first = false;
               continue;
            }
           
            if (c > '9' || c < '0') break;
            val = val * 10 + c - '0';
           
            if (val*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (val*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
           
        }
        val *= sign;

        return (int) val;        
    }
}
