class Solution {
    Map<String, List<Node>> adj;
    Set<String> vis;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String src = equation.get(0), target = equation.get(1);
            adj.computeIfAbsent(src, k -> new ArrayList<>()).add(new Node(target, values[i]));
            adj.computeIfAbsent(target, k -> new ArrayList<>()).add(new Node(src, 1 / values[i]));
        }
        int qn = queries.size();
        double[] res = new double[qn];
        for (int i = 0; i < qn; i++) {
            List<String> query = queries.get(i);
            String src = query.get(0), target = query.get(1);
            if (src.equals(target)) {
                if (adj.containsKey(src)) {
                    res[i] = 1;
                } else {
                    res[i] = -1;
                }
            } else {
                vis = new HashSet<>();
                res[i] = solve(src, target, 1);
            }
        }
        return res;
    }

    private double solve(String src, String target, double mul) {
        if (src.equals(target)) {
            return mul;
        }
        vis.add(src);
        if (adj.containsKey(src)) {
            for (Node neigh: adj.get(src)) {
                String v = neigh.str;
                double val = neigh.val;
                if (vis.contains(v)) continue;
                double res = solve(v, target, mul * val);
                if (res != -1) return res;
            }
        }
        return -1;
    }
}

class Node {
    public String str;
    public double val;

    public Node(String str, double val) {
        this.str = str;
        this.val = val;
    }
}