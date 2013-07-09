/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.
For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
*/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function       
        return restoreIpAddressesHelper(s, 4);
    }
   
    public ArrayList<String> restoreIpAddressesHelper(String s, int n) {
        ArrayList<String> results = new ArrayList<String>();
        if (s == null) return results;
        int len = s.length();
        if (len < n) return results;
       
        if (n == 1) {
            if (isValid(s)) results.add(s);
            return results;
        }
       
        for (int i = 1; i <= len; i++) {
            if (isValid(s.substring(0,i))) {
               ArrayList<String> subResults =
                    restoreIpAddressesHelper(s.substring(i), n-1);
               for (String r : subResults) {
                   results.add(s.substring(0,i) + "." + r);
               }  
            }
        }
        return results;
    }
   
    boolean isValid(String s) {
        int len = s.length();
        if (len == 1) return true;
        if (len > 3) return false;
       
        if (s.charAt(0) == '0') return false;
       
        if (len == 2) return true;

        int val = (s.charAt(0) - '0')*100 + (s.charAt(1) - '0')*10 + (s.charAt(2) - '0');
        return val < 256;
    }
}
