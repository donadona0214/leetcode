/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
         if (s == null || s.isEmpty()) return 0;
         Set<Integer> breaks = new HashSet<Integer>();
         int len = s.length();
         int leftCount = 0, rightCount = 0;
         int maxNum = 0;
         int num = 0;
         
         for (int i=0; i<len; i++) {
           if (s.charAt(i) == '(') leftCount++;
           if (s.charAt(i) == ')') {
              if (rightCount < leftCount) {
                  rightCount++;
              } else {
                  breaks.add(i);
                  leftCount = 0;
                  rightCount = 0;
               }
           }
         }
         
         leftCount = 0;
         rightCount = 0;
         for (int i=len-1; i>=0; i--) {
           if (s.charAt(i) == ')') rightCount++;
           if (s.charAt(i) == '(') {
              if (leftCount < rightCount) {
                  leftCount++;
              } else {
                  breaks.add(i);
                  leftCount = 0;
                  rightCount = 0;
               }
           }
         }
         
         leftCount = 0;
         rightCount = 0;
         for (int i=0; i<len; i++) {
           if (breaks.contains(i)) {
               num = Math.min(leftCount, rightCount)*2;
               if (num > maxNum) maxNum = num;
               leftCount = rightCount = 0;
               continue;
           }
           if (s.charAt(i) == '(') leftCount++;
           if (s.charAt(i) == ')') rightCount++;
         }

         num = Math.min(leftCount, rightCount)*2;
         if (num > maxNum) maxNum = num;

         return maxNum;
    }
} 
