class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> vis;

    public int countComponents(int n, int[][] edges) {
        int res = 0;
        adj = new HashMap<>();
        vis = new HashSet<>();
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                dfs(i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int u) {
        vis.add(u);
        if (adj.containsKey(u)) {
            for (int v: adj.get(u)) {
                if (!vis.contains(v)) {
                    dfs(v);
                }
            }
        }
    }
}
