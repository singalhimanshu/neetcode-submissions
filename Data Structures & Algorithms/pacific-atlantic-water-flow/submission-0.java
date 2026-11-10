class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] heights;
    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            q.offer(new int[]{r, 0});
        }
        for (int c = 0; c < cols; c++) {
            q.offer(new int[]{0, c});
        }
        boolean[][] pacific = fillWater(q);
        for (int r = 0; r < rows; r++) {
            q.offer(new int[]{r, cols - 1});
        }
        for (int c = 0; c < cols; c++) {
            q.offer(new int[]{rows - 1, c});
        }
        boolean[][] atlantic = fillWater(q);
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(r);
                    cur.add(c);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    private boolean[][] fillWater(Queue<int[]> q) {
        boolean[][] res = new boolean[rows][cols];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            res[r][c] = true;
            for (int i = 0; i < dx.length; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || res[nr][nc] 
                || heights[nr][nc] < heights[r][c]) {
                    continue;
                }
                res[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        // for (int r = 0; r < rows; r++) {
        //     for (int c = 0; c < cols; c++) {
        //         System.out.print(res[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        return res;
    }
}
