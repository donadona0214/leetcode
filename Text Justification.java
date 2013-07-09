/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.
For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.
Return the formatted lines as:

[   "This    is    an",   "example  of text",   "justification.  "]
*/

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<String> emptyResults = new ArrayList<String>();
        emptyResults.add("");
       
        if (words == null) return emptyResults;
        int len = words.length;
        if (len == 0 || L == 0) return emptyResults;
       
        int s = 0;
        int sumLen = words[0].length();
       
        for (int i=1; i<len; i++) {
            int newSumLen = sumLen + words[i].length() + 1;
            if (newSumLen > L) {
                if (i-1 == s) {
                    results.add(leftJustifyHelper(words, s, i-1, L, sumLen));
                } else {
                    results.add(fullJustifyHelper(words, s, i-1, L, sumLen));
                }
               
                s = i;
                sumLen = words[i].length();
            } else {
                sumLen = newSumLen;
            }
        }
        results.add(leftJustifyHelper(words, s, len-1, L, sumLen));
       
        return results;
    }
   
    public String fullJustifyHelper(String[] words, int s, int e, int L, int sumLen) {
        int extraSpace = (L - sumLen)/(e-s);
        String str = words[s];
       
        int remaining = L - sumLen - extraSpace*(e-s);
        String spaces = "";
        for (int j=0; j<extraSpace; j++) spaces += " ";
       
        for (int i = s+1; i <= e; i++) {
            str += spaces;
            if (remaining > 0) {
                str += " ";
                remaining --;
            }
            str += " " + words[i];
        }       
        return str;
    }
   
    public String leftJustifyHelper(String[] words, int s, int e, int L, int sumLen) {
        String str = words[s];
        for (int i = s+1; i <= e; i++) {
            str += " " + words[i];
        }
        while (str.length() < L) str += " ";
        return str;
    }
}
