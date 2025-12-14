class Solution {

    public boolean isSafe(char[][] board, int row, int col, char val) {

        // Row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }

        // Sub-grid check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }

    public boolean sudokuHelper(char[][] board, int row, int col) {

        if (row == 9) return true;

        if (col == 9) return sudokuHelper(board, row + 1, 0);

        if (board[row][col] != '.') {
            return sudokuHelper(board, row, col + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (isSafe(board, row, col, ch)) {
                board[row][col] = ch;

                if (sudokuHelper(board, row, col + 1)) return true;

                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        sudokuHelper(board, 0, 0);
    }
}
