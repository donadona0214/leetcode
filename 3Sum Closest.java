/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.    
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
      
        int closeAbsDiff = Integer.MAX_VALUE;
        int closeSum = Integer.MIN_VALUE;
        for (int i=0; i<num.length-2; i++) {
            int j = i + 1;
            int k = num.length - 1;
          
            while (j<k) {
               int sum = num[i] + num[j] + num[k];
               int diff = sum - target;
               int absDiff = Math.abs(diff);
             
               if(absDiff < closeAbsDiff) {
                   closeSum = sum;
                   closeAbsDiff = absDiff;
               }
             
               if (diff >0) k--;
               if (diff ==0) break;
               if (diff < 0) j++;
            }
            if(closeAbsDiff == 0) {
                break;
            }
        }
      
        return closeSum;
    }
}
