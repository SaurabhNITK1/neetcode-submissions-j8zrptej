/**
Also see two pointer solution prev one.

We want to buy at the lowest price seen so far.
Every time we see a lower price, we shift our buy pointer.
Every time we see a higher price, we update potential profit.
This ensures:

We only buy before we sell
We compute max profit in O(n) time with a single pass

**/

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}