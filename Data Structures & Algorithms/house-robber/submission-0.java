class Solution {
    public int rob(int[] nums) {
        int robPrevPrev = 0, robPrev = 0;
        for (int num : nums) {
            int tmp = Math.max(num + robPrevPrev, robPrev);
            robPrevPrev = robPrev;
            robPrev = tmp;
        }
        return robPrev;
    }
}
