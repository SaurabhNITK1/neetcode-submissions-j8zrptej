class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) { 
    char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }


    // rowSize = columnSize = n, unidirectional dfs iterate through each rows as each row must place 
    // a queen. If any row not able to give a place to queen then that solution wouldnot hold
    dfs(n, 0, board, new HashSet<>(), new HashSet<>(), new HashSet<>());
    return result;
    }

    
    private void dfs(int n, int r, char[][] board, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        // iterate over each row (row = column length) to get a suitable position. For n*n rowLength = columnLength = n
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row: board) {
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }
        for (int c = 0; c < n; c++) {   // n column length

            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }

            // got a safe position, build hashes
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            dfs(n, r + 1, board, cols, posDiag, negDiag);

            cols.remove(c);       // backtrack, remove hashes
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }

    }
}
