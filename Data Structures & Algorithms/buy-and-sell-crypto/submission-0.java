class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        final Stack<Integer> stk = new Stack<>();
        stk.push(prices[0]);
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (stk.peek() > prices[i]) {
                stk.pop();
                stk.push(prices[i]);
            } else {
                result = Math.max(result, prices[i] - stk.peek());
            }
        }
        return result;
    }
}
