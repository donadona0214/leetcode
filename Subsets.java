/*
Given a set of distinct integers, S, return all possible subsets.
Note:

   * Elements in a subset must be in non-descending order.
   * The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:
[  [3],  [1],  [2],  [1,2,3],  [1,3],  [2,3],  [1,2],  []]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (S == null) return results;
        Arrays.sort(S);
        return subsetsHelper(S, 0);
    }
   
    public ArrayList<ArrayList<Integer>> subsetsHelper(int[] S, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int len = S.length;
        if (len == 0) return results;
        if (k == len) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            results.add(result);
            return results;
        };
       
        ArrayList<ArrayList<Integer>> subResults = subsetsHelper(S, k+1);
        for (ArrayList<Integer> r : subResults) {
            ArrayList<Integer> rr = (ArrayList<Integer>) r.clone();
            rr.add(0, S[k]);
            results.add(r);
            results.add(rr);
        }
        return results;
    }
}
