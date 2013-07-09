/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
        Map<String, Integer> huns= new HashMap<String, Integer>();
        huns.put("C", 1);
        huns.put("CC", 2);
        huns.put("CCC", 3);
        huns.put("CD", 4);
        huns.put("D", 5);
        huns.put("DC", 6);
        huns.put("DCC", 7);
        huns.put("DCCC", 8);
        huns.put("CM", 9);
       
        Map<String, Integer> tens= new HashMap<String, Integer>();
        tens.put("X", 1);
        tens.put("XX", 2);
        tens.put("XXX", 3);
        tens.put("XL", 4);               
        tens.put("L", 5);
        tens.put("LX", 6);       
        tens.put("LXX", 7);
        tens.put("LXXX", 8);
        tens.put("XC", 9);

        Map<String, Integer> ones= new HashMap<String, Integer>();
        ones.put("I", 1);
        ones.put("II", 2);
        ones.put("III", 3);
        ones.put("IV", 4);
        ones.put("V", 5);
        ones.put("VI", 6);
        ones.put("VII", 7);
        ones.put("VIII", 8); 
        ones.put("IX", 9); 
       
        int num = 0;
        while (s.length() > 0 && s.charAt(0) == 'M') {
            num += 1000;
            s = s.substring(1);
        }
       
        String hun = getSingleValue(s, huns);
        if (hun != null) {
            num += huns.get(hun) * 100;
            s = s.substring(hun.length());
        }
       
        String ten = getSingleValue(s, tens);
        if (ten != null) {
            num += tens.get(ten) * 10;
            s = s.substring(ten.length());
        }
       
        String one = getSingleValue(s, ones);
        if (one != null) {
            num += ones.get(one);
        }
       
        return num;
    }
   
    String getSingleValue(String s, Map<String, Integer> map) {
       for (int i=Math.min(4, s.length()); i>0; i--) {
            String sub = s.substring(0,i);
            Integer val = map.get(sub);
            if (hun != null) {
                return sub;
            }
        }   
        return null;
    }
}
