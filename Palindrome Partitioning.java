/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [    ["aa","b"],    ["a","a","b"]  ]
*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
      
        ArrayList<String> subResult = new ArrayList<String>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
      
        int len = s.length();
        if (len == 1) {
            subResult.add(s);
            result.add(subResult);
            return result;
        }
      
        if (isPalindrome(s)) {
            subResult.add(s);
            result.add(subResult);
        }         
      
        for (int i=1; i< len; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (!isPalindrome(left)) continue;

            ArrayList<ArrayList<String>> resultRight = partition(s.substring(i));
          
            for (int j=0; j<resultRight.size(); j++) {
                    ArrayList<String> combinedResult = new ArrayList<String>();
                    combinedResult.add(left);
                    combinedResult.addAll(resultRight.get(j));
                    result.add(combinedResult);
            }
          
        }
        return result;
    }
  
    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }
}
