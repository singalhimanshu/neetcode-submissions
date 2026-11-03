class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0;
        int res = 0;
        int maxOcc = 0;
        for (int r = 0; r < s.length(); r++) {
            int curFreqIdx = s.charAt(r) - 'A';
            freq[curFreqIdx]++;
            maxOcc = Math.max(maxOcc, freq[curFreqIdx]);
            int noOfReplacements = r - l + 1 - maxOcc;
            if (noOfReplacements > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
