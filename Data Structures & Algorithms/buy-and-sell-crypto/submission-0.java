class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0;
        for (int r = 0; r < prices.length; r++) {
            max = Math.max(max, prices[r]-prices[l]);
            if (prices[l] > prices[r]) {
                l = r;
            }
        }
        return max;
    }
}