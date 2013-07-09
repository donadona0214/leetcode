/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null) return 0;
        int len = prices.length;
        if (len <= 1) return 0;
       
        int[] firstProfit = new int[len + 1];
        int[] secondProfit = new int[len + 1];
       
        int maxP = 0;
        int min = prices[0];
        firstProfit[0] = firstProfit[1] = 0;
        for(int i = 1; i < len; i++) {
            int profit = prices[i] - min;
            if (profit > maxP) maxP = profit;
            firstProfit[i+1] = maxP;
          
            if (prices[i] < min) min = prices[i];
        }
       
        maxP = 0;
        int max = prices[len-1];
        firstProfit[len] = firstProfit[len-1] = 0;
        for(int i = len-2; i >= 0; i--) {
            int profit = max - prices[i];
            if (profit > maxP) maxP = profit;
            secondProfit[i] = maxP;
          
            if (prices[i] > max) max = prices[i];
        }
       
        maxP = 0;
        for (int i=0; i<=len; i++) {
            int profit = firstProfit[i] + secondProfit[i];
            if (profit > maxP) maxP = profit;
        }
       
        return maxP;
    }
}
