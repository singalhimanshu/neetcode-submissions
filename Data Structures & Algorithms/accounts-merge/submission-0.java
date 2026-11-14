class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<Integer, Set<String>> idxToEmails = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> list = accounts.get(i);
            idxToEmails.computeIfAbsent(i, k -> new TreeSet<>()).addAll(list.subList(1, list.size()));
            for (int j = i + 1; j < n; j++) {
                Set<String> set1 = new HashSet<>(accounts.get(i));
                Set<String> set2 = new HashSet<>(accounts.get(j));
                set1.retainAll(set2);
                if (set1.size() > 1) {
                    dsu.union(i, j);
                }
            }
        }
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = dsu.find(i);
            map.computeIfAbsent(p, k -> new TreeSet<>()).addAll(idxToEmails.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (var entry: map.entrySet()) {
            int idx = entry.getKey();
            Set<String> emails = entry.getValue();
            String name = accounts.get(idx).get(0);
            List<String> cur = new ArrayList<>();
            cur.add(name);
            cur.addAll(emails);
            res.add(cur);
        }
        return res;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
        return true;
    }
}