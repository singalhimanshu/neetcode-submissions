class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp = new Integer[n + 1];
        return solve(0, n);
    }

    private int solve(int at, int n) {
        if (at > n) return 0;
        if (at == n) return 1;
        if (dp[at] != null) return dp[at];
        int one = solve(at + 1, n);
        int two = solve(at + 2, n);
        return dp[at] = one + two;
    }
}
