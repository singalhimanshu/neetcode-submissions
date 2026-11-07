class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int sum = 0;
        freq.put(0, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int target = sum - k;
            if (freq.containsKey(target)) {
                res += freq.get(target);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}