class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            boolean ok = true;
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) != c) {
                    ok = false;
                    break;
                }
            }
            if (!ok) break;
            sb.append(c);
        }
        return sb.toString();
    }
}