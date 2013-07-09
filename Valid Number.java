/*
Validate if a given string is numeric.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one
*/

public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s=s.trim();
      
        if(s.isEmpty()) return false;
        boolean bDot = false, bExp = false, bSign = false, bNumeric = false;;
       
        int len = s.length();
        if (len == 1 && !isNumeric(s.charAt(0))) return false;
       
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
           
            if (c == '+' || c == '-') {
                if (bNumeric || bSign) return false;
                bSign = true;
            } else if (c == '.') {
                if (bDot || bExp) return false;
                bDot = true;
            } else if (c == 'e') {
                if (bExp || !bNumeric) return false;
                bExp = true;
                bNumeric = false;
                bSign = false;
            } else if(!isNumeric(c)) {
                return false;
            } else {
                bNumeric = true;
            }
        }
      
        if (!bNumeric) return false;
       
        return true;
    }
  
    public boolean isNumeric(char c) {
        return (c>='0' && c<='9');
    }
}
