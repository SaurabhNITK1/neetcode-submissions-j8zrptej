class Solution {
    public int maxProfit(int[] prices) {
        int start = 0, end = 0;
        int maxProfit = 0;
        while (end < prices.length) {
            int currentProfit = 0;
            currentProfit = prices[end] - prices[start];
            maxProfit = Math.max(currentProfit, maxProfit);
            if (currentProfit<0) {
                // till this point for the array behind end pointer maxProfit has been
                // already calculated and saved in maxProfit variable
                // If you reached this means you found a new price to buy stock at lower cost. so do start = end               
                start=end; // New lower found
            }
            else {
               end++;  
            } 
        }
        return maxProfit;
    }
}
