class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int result = -1;
        while (l <= r) {
            int midIdx = (l + r) / 2;
            if (nums[midIdx] > target) {
                r = midIdx - 1;
            } else if (nums[midIdx] < target) {
                l = midIdx + 1;
            } else {
                result = midIdx;
                break;
            }
        }
        return result;
    }
}
