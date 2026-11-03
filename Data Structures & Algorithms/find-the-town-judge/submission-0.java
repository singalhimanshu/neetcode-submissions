class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];
        for (int[] t: trust) {
            int u = t[0], v = t[1];
            indeg[v]++;
            outdeg[u]++;
        }
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == n - 1 && outdeg[i] == 0) return i;
        }
        return -1;
    }
}