class Pair {
    private int idx;
    private int val;

    public Pair(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }

    public int getIdx() {
        return this.idx;
    }
}

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }
        Arrays.sort(pairs, Comparator.comparing(Pair::getVal));
        int l = 0, r = pairs.length - 1;
        while (l < r) {
            int sum = pairs[l].getVal() + pairs[r].getVal();
            if (sum == target) {
                break;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        int[] result = {pairs[l].getIdx(), pairs[r].getIdx()};
        Arrays.sort(result);
        return result;
    }
}
