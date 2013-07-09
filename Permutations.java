/*
Given a collection of numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:

[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return permuteHelper(num, 0);
    }
   
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int s) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
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
            swap(num, s, i);
            ArrayList<ArrayList<Integer>> subResults = permuteHelper(num, s+1);
            for (ArrayList<Integer> sr : subResults) {
                sr.add(0, num[s]);
                results.add(sr);
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
