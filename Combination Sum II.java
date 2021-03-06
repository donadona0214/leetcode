/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
   * All numbers (including target) will be positive integers.
   * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
   * The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 

[1, 1, 6] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results = combinationSumHelper(num, num.length, target);
       
        ArrayList<ArrayList<Integer>> dedupResults = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> uniq = new HashSet<ArrayList<Integer>>();
       
        for (ArrayList<Integer> r : results) {
            if (!uniq.contains(r)) {
                dedupResults.add(r);
                uniq.add(r);
            }
        }
        return dedupResults;
    }
  
    public ArrayList<ArrayList<Integer>> combinationSumHelper(int[] candidates, int m, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            results.add(new ArrayList<Integer>());
        }
        if (m <= 0) return results;

        int val = candidates[m-1];
        int remaining = target;
        int count = 0;
        while (remaining >= 0 && count < 2) {
            ArrayList<ArrayList<Integer>> subResults =
                combinationSumHelper(candidates, m-1, remaining);
            for (ArrayList<Integer> r : subResults) {
                for (int i=0; i<count; i++) {
                    r.add(val);
                }
                results.add(r);
            }
            count ++;
            remaining = target - val*count;
        }
        return results;
    }
}
