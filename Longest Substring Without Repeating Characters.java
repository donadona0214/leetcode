/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.isEmpty()) return 0;
      
        Map<String, Integer> hitMap = new HashMap<String, Integer>();
        int start = 0, len = 0, maxLen = 0;
        for (int i = 0; i< s.length(); i++) {
            String c = s.substring(i, i+1);
            Integer index = hitMap.get(c);
            if (index == null) {
                len ++;
            } else {
                if (len > maxLen) maxLen = len;
              
                for (int j=start; j<=index; j++) {
                    hitMap.remove(s.substring(j, j+1));
                }
                start = index + 1;
                len = i - index;
            }
            hitMap.put(c, i);
        }
      
        if (len > maxLen) maxLen = len;

        return maxLen;
    }
}
