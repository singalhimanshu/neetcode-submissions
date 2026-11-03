class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        assert matrix.length > 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bot = rows - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][cols - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }
        if (!(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int startCol = 0, endCol = cols - 1;
        while (startCol <= endCol) {
            int midCol = (startCol + endCol) / 2;
            if (matrix[row][midCol] > target) {
                endCol = midCol - 1;
            } else if (matrix[row][midCol] < target) {
                startCol = midCol + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
