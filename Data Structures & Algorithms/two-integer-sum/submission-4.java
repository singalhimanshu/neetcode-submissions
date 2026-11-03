class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int t = target - num;
            if (map.containsKey(t)) {
                return new int[]{map.get(t), i};
            }
            map.put(num, i);
        }
        return new int[]{};
    }
}
