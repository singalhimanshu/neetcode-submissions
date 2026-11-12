class Solution {
    public int[] findOrder(int n, int[][] preqs) {
        int[] indeg = new int[n];
        int[] res = new int[n];
        int idx = 0;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] preq: preqs) {
            int a = preq[0], b = preq[1];
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            indeg[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int d = 0;
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            res[idx++] = u;
            d++;
            if (adj.containsKey(u)) {
                for (int v: adj.get(u)) {
                    indeg[v]--;
                    if (indeg[v] == 0) {
                        q.offer(v);
                    }
                }
            }
        }
        return d == n ? res : new int[]{};
    }
}
