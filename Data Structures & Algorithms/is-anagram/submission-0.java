class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for (char ch: s.toCharArray()) {
            int asciNum = (int) ch - (int) 'a';
            int curFreq = freq[asciNum];
            freq[asciNum] = curFreq + 1;
        }
        for (char ch: t.toCharArray()) {
            int asciNum = (int) ch - (int) 'a';
            if (freq[asciNum] == 0) {
                return false;
            }
            int curFreq = freq[asciNum];
            freq[asciNum] = curFreq - 1;
        }
        for (int curFreq : freq) {
            if (curFreq > 0) {
                return false;
            }
        }
        return true;
    }
}
