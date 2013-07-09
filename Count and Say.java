/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        int len = prev.length();
        char[] val = new char[len];
        int[] hist = new int[len];
        int index = 0;
      
        val[0] = prev.charAt(0);
        hist[0] = 1;
      
        for (int i = 1; i < len; i++) {
            if (prev.charAt(i) == prev.charAt(i-1)) {
                hist[index] += 1;
            } else {
                index ++;
                val[index] = prev.charAt(i);
                hist[index] = 1;
            }
        }
      
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<=index; i++) {
            sb.append(hist[i]);
            sb.append(val[i]);
        }
        return sb.toString();
    }
}
