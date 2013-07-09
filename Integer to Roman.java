/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
        String[] huns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
       
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            sb.append("M");
            num -= 1000;
        }
       
        if (num >= 100) {
            sb.append(huns[num/100]);
            num = num % 100;
        }
       
        if (num >= 10) {
            sb.append(tens[num/10]);
            num = num % 10;
        }
       
        sb.append(ones[num]);
       
        return sb.toString();
    }
}
