class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (final String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int i = 0;
        for (i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            boolean end = false;
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
        }
        if (i == 0) return "";
        return strs[0].substring(0, i);
    }
}