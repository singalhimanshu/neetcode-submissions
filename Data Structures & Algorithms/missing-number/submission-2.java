class Solution {
    public int missingNumber(int[] nums) {
        final int n = nums.length;
        int xor = n;
        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
}
