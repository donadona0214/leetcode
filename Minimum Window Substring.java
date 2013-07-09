/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (T == null || S == null) return "";
        int lenT = T.length(), lenS = S.length();
        if (lenT == 0 || lenS == 0) return "";
        Map<String, Integer> matchMap = new HashMap<String,Integer>();
        for (int i = 0; i < lenT; i++) {
            String t = T.substring(i, i+1);
            Integer count = matchMap.get(t);
            if (count == null) {
                matchMap.put(t, 1);
            } else {
                matchMap.put(t, count + 1);
            }
        }
       
        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        PriorityQueue<Integer> indexSet = new PriorityQueue<Integer>();
       
        String minWin = "";
        int num = 0;
        for (int i = 0; i < lenS; i ++) {
            String s = S.substring(i, i+1);
            Integer count = matchMap.get(s);
            if (count == null) continue;
           
            ArrayList<Integer> indexes = map.get(s);
            if (indexes == null) {
                indexes = new ArrayList<Integer>();
                map.put(s, indexes);
            }
           
            if (indexes.size() < count) num ++;
           
            indexes.add(i);
            indexSet.add(i);
           
            while (indexSet.size() > 0) {
                int idx = indexSet.peek();
                String front = S.substring(idx, idx+1);
               
                if (map.get(front).size() <= matchMap.get(front)) {
                    break;
                }
                map.get(front).remove(0);
                indexSet.poll();
            }
           
            if (num >= lenT) {
                String win = S.substring(indexSet.peek(), i+1);
                if (minWin == "" || minWin.length() > win.length()) {
                    minWin = win;
                }
            }
        }
        return minWin;
    }
}
