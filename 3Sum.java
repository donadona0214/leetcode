/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:
   * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
   * The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},    A solution set is:    (-1, 0, 1)    (-1, -1, 2)
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        List<Integer> sortedNum = sortIntArray(num);
        Set<ArrayList<Integer>> threeSumIndexesSet = new HashSet<ArrayList<Integer>>();
       
        int len = sortedNum.size();
        for (int i=len-1; i>1; i--) {
            ArrayList<ArrayList<Integer>> twoSumIndexesSet = twoSumSortArray(sortedNum.subList(0, i), sortedNum.get(i) * -1);
            for(ArrayList<Integer> index : twoSumIndexesSet) {
                index.add(sortedNum.get(i));
                threeSumIndexesSet.add(index);
            }
        } 
          
        return toArrayListFromSet(threeSumIndexesSet);
    }
     
      public ArrayList<ArrayList<Integer>> toArrayListFromSet(Set<ArrayList<Integer>> indexSet) {
                  ArrayList<ArrayList<Integer>> indexes = new ArrayList<ArrayList<Integer>>();
                 for(ArrayList<Integer> index : indexSet) {
                    indexes.add(index);
                 }
                 return indexes;
      }
   
    public ArrayList<Integer> sortIntArray(int[] num) {
        ArrayList<Integer> sortedNum = new ArrayList<Integer>(num.length);
        for (int n : num) {
            sortedNum.add(n);
        }
        Collections.sort(sortedNum);
        return sortedNum;
    }

   
    public ArrayList<ArrayList<Integer>> twoSumSortArray(List<Integer> num, int val) {
        Set<ArrayList<Integer>> twoSumIndexesSet = new HashSet<ArrayList<Integer>>();
        int len = num.size();
        int start = 0, end = len -1;
        while (start < end) {
            int sum = num.get(start) + num.get(end);
            if (sum < val) {
                start ++;
                continue;
            } else if (sum > val) {
                end --;
                continue;
            } else if (sum == val) {
                ArrayList<Integer> tuple = new ArrayList<Integer>();
                tuple.add(num.get(start));
                          tuple.add(num.get(end));
                twoSumIndexesSet.add(tuple);
                start ++;
                end --;
            }
        }
           
        return toArrayListFromSet(twoSumIndexesSet);
    }

}
