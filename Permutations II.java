/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:

[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return permuteHelper(num, 0);
    }
 
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int s) {       
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
       
        Set<ArrayList<Integer>> uniq = new HashSet<ArrayList<Integer>>();
        if (num == null) return results;
        int len = num.length;
        if (len == 0) return results;
        if (s == len-1) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(num[s]);
            results.add(result);
            return results;
        }
     
        for (int i = s; i < len; i++) {
            if (i != s && num[i] == num[s]) continue;
            swap(num, s, i);
            ArrayList<ArrayList<Integer>> subResults = permuteHelper(num, s+1);
            for (ArrayList<Integer> sr : subResults) {
                sr.add(0, num[s]);
                if (!uniq.contains(sr)) {
                     results.add(sr);
                     uniq.add(sr);
                }
            }
            swap(num, s, i);
        }
        return results;
 
    }
 
    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
