/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateParenthesisHelper(n, n);
    }
   
    public ArrayList<String> generateParenthesisHelper(int left, int right) {
        ArrayList<String> results = new ArrayList<String>(),
            rightResults = new ArrayList<String>(),
            leftResults = new ArrayList<String>();
        if (right >0 && right > left) {
            ArrayList<String> subResults = generateParenthesisHelper(left, right -1);
            for (String s: subResults) {
                rightResults.add(")" + s);
            }
            if (subResults.isEmpty()) rightResults.add(")");
        }

        if (left >0) {
            ArrayList<String> subResults = generateParenthesisHelper(left-1, right);
            for (String s: subResults) {
                leftResults.add("(" + s);
            }
            if (subResults.isEmpty()) leftResults.add("(");
        }
        results.addAll(leftResults);
        results.addAll(rightResults);
        return results;       
    }
}
