class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int result = 0;
        for (int r = 1; r < prices.length; r++) {
            if (prices[r] > prices[l]) {
                result = Math.max(result, prices[r] - prices[l]);
            } else {
                l = r;
            }
        }
        return result;
    }
}
