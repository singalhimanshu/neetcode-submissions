class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long sqr = (long) mid * mid;
            if (sqr == x) {
                return mid;
            }
            if (sqr > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}