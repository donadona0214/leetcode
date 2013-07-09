/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.
Note:
   * Elements in a subset must be in non-descending order.
   * The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:
[  [2],  [1],  [1,2,2],  [2,2],  [1,2],  []] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (S == null) return results;
        Arrays.sort(S);
        Set<ArrayList<Integer>> resultsSet = subsetsHelper(S, 0);
        for (ArrayList<Integer> r : resultsSet) {
            results.add(r);
        }
        return results;
    }
   
    public Set<ArrayList<Integer>> subsetsHelper(int[] S, int k) {
        HashSet<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
        int len = S.length;
        if (len == 0) return results;
        if (k == len) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            results.add(result);
            return results;
        };
       
        Set<ArrayList<Integer>> subResults = subsetsHelper(S, k+1);
        for (ArrayList<Integer> r : subResults) {
            //ArrayList<Integer> rr = new ArrayList<Integer>();
            ArrayList<Integer> rr = (ArrayList<Integer>) r.clone();
            rr.add(0, S[k]);
            //rr.addAll(r);
            results.add(r);
            results.add(rr);
        }
        return results;
    }
}
