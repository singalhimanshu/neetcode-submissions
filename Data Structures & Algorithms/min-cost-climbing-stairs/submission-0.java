class Solution {
    int[] cost;
    Integer[] dp;
    int n;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        this.cost = cost;
        dp = new Integer[n];
        return Math.min(solve(0), solve(1));
    }

    int solve(int idx) {
        if (idx >= n) return 0;
        if (dp[idx] != null) return dp[idx];
        int oneFloor = cost[idx] + solve(idx + 1);
        int twoFloor = cost[idx] + solve(idx + 2);
        return dp[idx] = Math.min(oneFloor, twoFloor);
    }
}
