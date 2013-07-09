/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length <= 1) return 0;
      
        int len = prices.length;
      
        int maxP = 0;
        int min = prices[0];
        for(int i = 1; i < len; i++) {
            int profit = prices[i] - min;
            if (profit > maxP) maxP = profit;
           
            if (prices[i] < min) min = prices[i];
        }
        return maxP;      
    }
}
