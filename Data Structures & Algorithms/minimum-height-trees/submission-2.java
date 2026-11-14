class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indeg = new int[n];
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indeg[u]++;
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] <= 1) {
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int qn = q.size();
            res = new ArrayList<>();
            while (qn-- > 0) {
                int u = q.poll();
                res.add(u);
                if (adj.containsKey(u)) {
                    for (int v: adj.get(u)) {
                        indeg[v]--;
                        if (indeg[v] == 1) {
                            q.offer(v);
                        }
                    }
                }
            }
        }
        return res;
    }
}