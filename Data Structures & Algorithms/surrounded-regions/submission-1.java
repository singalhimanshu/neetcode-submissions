class Solution {
    char[][] board;
    int rows, cols;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || c == 0 || r == rows - 1 || c == cols - 1) && board[r][c] == 'O') {
                    q.offer(new int[]{r, c});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            board[r][c] = 'A';
            for (int i = 0; i < dx.length; i++) {
                int nr = r + dx[i], nc = c + dy[i];
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || board[nr][nc] != 'O') {
                    continue;
                }
                q.offer(new int[]{nr, nc});
                board[nr][nc] = 'A';
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'A') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
