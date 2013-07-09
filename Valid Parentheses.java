/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> remains = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    remains.push(s.substring(i,i+1)); break;
                case ')':
                case ']':
                case '}':
                    if (remains.isEmpty()) return false;
                    if ((remains.peek().equals("(") && c == ')') ||
                        (remains.peek().equals("[") && c == ']') ||
                        (remains.peek().equals("{") && c == '}')) remains.pop();
                    else remains.push(s.substring(i,i+1));
                    break;
                default:
                    continue;
            }
        }
       
        if (remains.isEmpty()) return true;

        return false;
    }
}
