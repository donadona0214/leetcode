/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1'B' -> 2...'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
*/

// bug. handle edge case. a) not valid at all b) 0 at tens or single ones
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null) return 0;
        int len = s.length();
        if (len == 0) return 0;
       
        int[] nums = new int[len+1];
        nums[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (isValid(s.substring(i-1,i))) {
                nums[i] = nums[i-1];
            } else {
                nums[i] = 0;
            }
           
            if (i > 1 && isValid(s.substring(i-2,i))) {
                nums[i] += nums[i-2];
            }
        }
        return nums[len];
    }
   
    public boolean isValid(String s) {
        if (s == null) return false;
        int len = s.length();
        if (len == 0) return false;
       
        if (s.charAt(0) == '0') return false;
        if (len == 1) return true;
        if (len > 2) return false;
        if ((s.charAt(0) - '0')* 10 + s.charAt(1) - '0' <=26) {
            return true;
        }
        return false;
    }
}
