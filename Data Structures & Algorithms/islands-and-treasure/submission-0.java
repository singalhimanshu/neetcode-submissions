class Solution {
    static final int INF = 2147483647;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (grid[r][c] < d) continue;
            for (int i = 0; i < dx.length; i++) {
                int nr = r + dx[i], nc = c + dy[i];
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] == -1) {
                    continue;
                }
                int nd = d + 1;
                if (nd < grid[nr][nc]) {
                    grid[nr][nc] = nd;
                    q.offer(new int[]{nr, nc, nd});
                }
            }
        }
    }
}
