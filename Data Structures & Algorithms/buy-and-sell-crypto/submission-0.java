class Solution {
    public int maxProfit(int[] prices) {
        int start = 0, end = 0;
        int maxProfit = 0;
        while (end < prices.length) {
            int currentProfit = 0;
            currentProfit = prices[end] - prices[start];
            maxProfit = Math.max(currentProfit, maxProfit);
            if (currentProfit<0)
               start=end;
            else
               end++;   
        }
        return maxProfit;
    }
}
