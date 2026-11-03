class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                nums[j] = nums[i];
                j++;
                count++;
            }
            set.add(nums[i]);
        }
        return count;
    }
}