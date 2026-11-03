class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i < steps.length; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
}
