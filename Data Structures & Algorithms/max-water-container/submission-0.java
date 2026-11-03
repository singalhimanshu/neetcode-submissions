class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int result = 0;
        while (l < r) {
            int minHeight = Math.min(heights[l], heights[r]);
            int curArea = minHeight * (r - l);
            result = Math.max(result, curArea);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
