/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
        int maxLen = 0;
        if (num == null) return 0;
        Map<Integer, Integer> start = new HashMap<Integer, Integer>();
        Map<Integer, Integer> end = new HashMap<Integer, Integer>();
        Set<Integer> uniq = new HashSet<Integer>();
       
       
        for(int i=0; i<num.length; i++) {
            if (uniq.contains(num[i])) {
                continue;
            } else {
                uniq.add(num[i]);
            }
           
            Integer nextStartLen = start.get(num[i]+1);
            int newStartLen = 1;
            if (nextStartLen != null) {
                newStartLen = nextStartLen + 1;
                start.put(num[i], newStartLen);
                start.remove(num[i]+1);
                end.put(num[i] + newStartLen-1, newStartLen);
            } else {
                start.put(num[i], newStartLen);
            }
           
            if (newStartLen > maxLen) maxLen = newStartLen;
           
            Integer lastEndLen = end.get(num[i]-1);
            int newEndLen = 1;
            if (lastEndLen != null) {
                newEndLen = lastEndLen + newStartLen;
                end.put(num[i] + newStartLen-1, newEndLen);
                end.remove(num[i]-1);
                start.put(num[i] - lastEndLen, newEndLen);
                start.remove(num[i]);
            } else {
                end.put(num[i], newEndLen);
            }
           
            if (newEndLen > maxLen) maxLen = newEndLen;
        }
        return maxLen;
    }
}
