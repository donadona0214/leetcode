/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   NA P L S I I GY   I   RAnd then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

// Did not handle the cases when nRows = 1, endless loop
public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null) return s;
        int len = s.length();
        if (nRows == 1) return s;
       
        int cycle = 2*nRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            int idx = i;
            int idx2 = cycle -i;
            while (idx < len) {
                //sb.append(s.charAt(idx));
                sb.append(s.substring(idx, idx+1));
                if (i != 0 && i != nRows -1 && idx2 < len) {
                    //sb.append(s.charAt(idx2));
                    sb.append(s.substring(idx2, idx2+1));
                }
                idx += cycle;
                idx2 += cycle;
            }
        }
       
        return sb.toString();
    }
}
