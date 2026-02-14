import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(0, n, 0, 0, 0, board, res);
        return res;
    }

    private void backtrack(int row, int n, int cols, int d1, int d2, char[][] board, List<List<String>> res) {
        if (row == n) {
            List<String> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) cur.add(new String(board[i]));
            res.add(cur);
            return;
        }

        int available = ((1 << n) - 1) & ~(cols | d1 | d2);
        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            int col = Integer.numberOfTrailingZeros(bit);
            board[row][col] = 'Q';

            backtrack(row + 1, n, cols | bit, (d1 | bit) << 1, (d2 | bit) >> 1, board, res);

            board[row][col] = '.';
        }
    }
}
