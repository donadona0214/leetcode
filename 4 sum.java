/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note:
   * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
   * The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.    A solution set is:    (-1,  0, 0, 1)    (-2, -1, 1, 2)    (-2,  0, 0, 2) 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultsList = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        int len = num.length;
        for (int i=0; i<len-3; i++) {
            for (int j=i+1; j<len-2; j++) {
                int newTarget = target - num[i] - num[j];
                int m = j + 1;
                int n = len - 1;
               
                while (m<n) {
                    int sum = num[m] + num[n];
                    if (sum == newTarget) {
                        ArrayList<Integer> result = new ArrayList<Integer>();
                        result.add(num[i]);
                        result.add(num[j]);
                        result.add(num[m]);
                        result.add(num[n]);
                        results.add(result);
                        m ++;
                        n --;
                    } else if (sum < newTarget) {
                        m ++;
                    } else {
                        n --;
                    }
                }
            }
        }
       
        for (ArrayList<Integer> r : results) resultsList.add(r);
        return resultsList;
    }
}
