class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }
        int l = 1, r = max, res = max;
        while (l <= r) {
            int k = (l + r) / 2;
            if (isPossibleToEat(k, piles, h)) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    private boolean isPossibleToEat(int k, int[] piles, int h) {
        int timeTaken = 0;
        for (int pile: piles) {
            timeTaken += Math.ceil((double) pile / k);
            if (timeTaken > h) {
                return false;
            }
        }
        return true;
    }
}
