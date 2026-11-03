class Solution {
    int n;
    int[] nums;
    int res;
    public int subsetXORSum(int[] nums) {
        res = 0;
        this.n = nums.length;
        this.nums = nums;
        solve(0, 0);
        return res;
    }

    private void solve(int idx, int xor) {
        if (idx >= n) {
            res += xor;
            return;
        }
        solve(idx + 1, nums[idx] ^ xor);
        solve(idx + 1, xor);
    }
}