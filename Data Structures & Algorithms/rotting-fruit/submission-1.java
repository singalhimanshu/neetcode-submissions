class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int time = 0;
        while (!q.isEmpty()) {
            int qs = q.size();
            while (qs-- > 0) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int i = 0; i < dx.length; i++) {
                    int nr = r + dx[i], nc = c + dy[i];
                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] != 1) {
                        continue;
                    }
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    fresh--;
                }
            }
            time++;
            if (fresh == 0) return time;
        }
        return -1;
    }
}
