/*
Given a number represented as an array of digits, plus one to the number.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (digits == null) return null;
        int len = digits.length;
       
        int[] result = new int[len];
        int c = 1;
        for (int i=len-1; i>=0; i--) {
            int sum = c + digits[i];
            c = sum / 10;
            result[i] = sum%10;
        }
       
        if (c != 0) {
            int[] newResult = new int[len+1];
            for (int i=len-1; i>1; i--) {
                newResult[i+1] = result[i];
            }
            newResult[0] = c;
            result = newResult;
        }
        return result;
    }
}
