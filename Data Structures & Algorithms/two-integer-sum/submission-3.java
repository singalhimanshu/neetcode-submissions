class Solution {

    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        final int  n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] ans = {map.get(target-nums[i]), i};
                return ans;
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
