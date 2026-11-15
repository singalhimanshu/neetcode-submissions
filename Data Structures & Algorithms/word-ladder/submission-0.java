class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int d = 0;
        Set<String> vis = new HashSet<>();
        vis.add(beginWord);
        while (!q.isEmpty()) {
            int qs = q.size();
            while (qs-- > 0) {
                String u = q.poll();
                if (u.equals(endWord)) {
                    return d + 1;
                }
                for (String v: wordList) {
                    if (vis.contains(v)) continue;
                    if (oneDiff(u, v)) {
                        vis.add(v);
                        q.offer(v);
                    }
                }
            }
            d++;
        }
        return 0;
    }

    private boolean oneDiff(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
                if (diff > 1) break;
            }
        }
        return diff == 1;
    }
}
