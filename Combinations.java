/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:
[  [2,4],  [3,4],  [2,3],  [1,2],  [1,3],  [1,4],] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return combineHelper(n, 1, k);
    }
   
    public ArrayList<ArrayList<Integer>> combineHelper(int n, int s, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (k == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            results.add(result);
            return results;
        }
       
        if (n-s+1 < k) return results;
       
        ArrayList<ArrayList<Integer>> subResults = combineHelper(n, s+1, k);
       
        for (ArrayList<Integer> r : subResults) {
            results.add(r);
        }
       
        subResults = combineHelper(n, s+1, k-1);
        for (ArrayList<Integer> r : subResults) {
            r.add(0, s);
            results.add(r);
        }
        return results;
    }
}
