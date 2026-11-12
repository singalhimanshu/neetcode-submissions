class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deadend: deadends) {
            set.add(deadend);
        }
        if (set.contains("0000")) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int d = 0;
        Set<String> vis = new HashSet<>();
        vis.add("0000");
        while (!q.isEmpty()) {
            int qs = q.size();
            while (qs-- > 0) {
                String cur = q.poll();
                if (cur.equalsIgnoreCase(target)) {
                    return d;
                }
                for (int i = 0; i < cur.length(); i++) {
                    char c = cur.charAt(i);
                    int next = ((c - '0') + 1) % 10;
                    int prev = ((c - '0') - 1);
                    char nextC = (char) (next + '0');
                    char prevC = prev == -1 ? '9' : (char) (prev + '0');
                    // System.out.println("next: " + next + " nextC: " + nextC + " prevC: " + prevC);
                    // return -1;
                    StringBuilder nextSb = new StringBuilder(cur);
                    nextSb.setCharAt(i, nextC);
                    String nextStr = nextSb.toString();
                    if (!set.contains(nextStr) && !vis.contains(nextStr)) {
                        vis.add(nextStr);
                        q.offer(nextStr);
                    }
                    StringBuilder prevSb = new StringBuilder(cur);
                    prevSb.setCharAt(i, prevC);
                    String prevStr = prevSb.toString();
                    if (!set.contains(prevStr) && !vis.contains(prevStr)) {
                        vis.add(prevStr);
                        q.offer(prevStr);
                    }
                }
            }
            d++;
        }
        return -1;
    }
}