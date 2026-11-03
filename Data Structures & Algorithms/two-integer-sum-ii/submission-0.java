class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r ) {
            int curSum = numbers[l] + numbers[r];
            if (target == curSum) {
                return new int[]{l + 1, r + 1};
            } else if (target > curSum) {
                l++;
            } else {
                r--;
            }
        }
        assert false;
        return new int[]{l + 1, r + 1};
    }
}


/*
non-decreasing

one indexed
i1 != i2
*/
