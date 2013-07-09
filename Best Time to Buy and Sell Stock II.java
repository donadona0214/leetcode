/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null) return 0;
        int len = prices.length;
        if (len <= 1) return 0;
       
        int buy = prices[0], sell=0;
        int profit = 0;
        boolean isBuy = true;
        for (int i = 1; i< len; i++) {
            if (prices[i] < prices[i-1]) {
                if (isBuy) {
                    buy = prices[i];
                } else {
                    profit += sell - buy;
                    isBuy = true;
                    buy = prices[i];
                }
            } else if (prices[i] > prices[i-1]) {
                if (isBuy) {
                    isBuy = false;
                    sell = prices[i];
                } else {
                    sell = prices[i];
                }
            }
        }
       
        if (!isBuy) profit += sell - buy;
        return profit;
    }
}
