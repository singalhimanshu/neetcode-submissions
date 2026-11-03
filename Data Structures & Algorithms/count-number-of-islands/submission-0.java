class Solution {
    // tlbr -> top, left, bottom, right
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];

        int islands = 0;
        for (int r= 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !vis[r][c]) {
                    islands++;
                    dfs(r, c, grid, vis);
                }
            }
        }
        return islands;
    }

    private void dfs(int r, int c, char[][] grid, boolean[][] vis) {
        int rows = grid.length, cols = grid[0].length;
        if (!isInRange(r, c, rows, cols)) {
            return;
        }
        if (grid[r][c] == '0' || vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        for (int i = 0; i < dx.length; i++) {
            int newR = dx[i] + r;
            int newC = dy[i] + c;
            dfs(newR, newC, grid, vis);
        }
    }

    private boolean isInRange(int r, int c, int rows, int cols) {
        return (r >= 0 && c >= 0 && r < rows && c < cols);
    }
}
