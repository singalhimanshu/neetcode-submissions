class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                res++;
                nums[j++] = nums[i];
            }
        }
        return res;
    }
}