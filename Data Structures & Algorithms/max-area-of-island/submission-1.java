class Solution {
    int[][] grid;
    int rows, cols;
    boolean[][] vis;
    int res = 0;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        vis = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!vis[r][c] && grid[r][c] == 1) {
                    area = 1;
                    dfs(r, c);
                }
            }
        }    
        return res;
    }

    private void dfs(int r, int c) {
        vis[r][c] = true;
        res = Math.max(res, area);
        for (int i = 0; i < dx.length; i++) {
            int nr = r + dx[i], nc = c + dy[i];
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] == 0 || vis[nr][nc]) continue;
            area++;
            dfs(nr, nc);
        }
    }
}
