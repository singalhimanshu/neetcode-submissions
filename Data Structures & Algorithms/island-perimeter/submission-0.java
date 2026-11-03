class Solution {
    int[][] grid;
    int rows, cols;
    boolean[][] vis;
    int res;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int islandPerimeter(int[][] grid) {
        res = 0;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        vis = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    dfs(r, c);
                    break;
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c) {
        if (vis[r][c]) return;
        vis[r][c] = true;
        for (int i = 0; i < dx.length; i++) {
            int nr = dx[i] + r;
            int nc = dy[i] + c;
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] == 0) {
                res++;
            } else {
                dfs(nr, nc);
            }
        }
    }
}