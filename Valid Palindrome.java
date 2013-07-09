/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty() || s.length() == 1) return true;
          s = s.toLowerCase();
          StringBuilder sb = new StringBuilder();
          for (int i=0; i < s.length(); i++) {
               char c = s.charAt(i);
               if ((c >='a' && c <= 'z') || (c >='0' && c <= '9')) {
                    sb.append(s.substring(i, i+1));
               }
          }
          String f = sb.toString();
          for (int i=0; i < f.length()/2; i++) {
               if (f.charAt(i) != f.charAt(f.length()-1-i)) {
                    return false;
               }
          }
         
          return true;
    }
}
