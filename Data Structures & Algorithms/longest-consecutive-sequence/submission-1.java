class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        final Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        } 
        int result = 1;
        for (int num: nums) {
            if (!numSet.contains(num - 1)) {
                int len = 1;
                while (numSet.contains(num + len)) {
                    len++;
                }
                result = Math.max(result, len);
            }
        }
        return result;
    }
}
