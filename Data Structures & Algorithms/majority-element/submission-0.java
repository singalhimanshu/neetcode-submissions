class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int maj = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == maj) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i];
                    count++;
                }
            }
        }
        return maj;
    }
}