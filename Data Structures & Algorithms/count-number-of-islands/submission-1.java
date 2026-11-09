class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    char[][] grid;
    boolean[][] vis;
    int rows, cols;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        this.vis = new boolean[rows][cols];
        int res = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!vis[r][c] && grid[r][c] == '1') {
                    res++;
                    dfs(r, c);
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c) {
        vis[r][c] = true;
        for (int i = 0; i < dx.length; i++) {
            int nr = r + dx[i], nc = c + dy[i];
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || vis[nr][nc] || grid[nr][nc] == '0') {
                continue;
            }
            dfs(nr, nc);
        }
    }
}
