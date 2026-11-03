class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>(nums.length);
        boolean duplicateFound = false;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                duplicateFound = true;
                break;
            }
            set.add(nums[i]);
        }
        return duplicateFound;
    }
}
