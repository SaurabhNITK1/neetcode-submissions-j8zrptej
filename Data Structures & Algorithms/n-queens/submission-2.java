/*
Algo;
1. We place queens row by row using DFS, and use three hash sets to track column and diagonal 
conflicts, ensuring O(1) safety checks and backtracking to explore all valid board configurations.

2.Diagonals are identified using (r + c) and (r - c) since their sum stay constant along those paths.
  you can try this out in a 2d matrix



1. Initialize data structures

Create an empty result list.
Create an n x n board filled with '.'.
Create 3 sets:

cols → to track occupied columns
posDiag → to track (row + col) diagonals
negDiag → to track (row - col) diagonals




2. Start DFS from row 0

Call DFS function with:

current row = 0
board
the 3 sets




3. Base case (solution found)

If row == n:

Convert board into List<String>
Add it to result
Return




4. Try placing queen in current row

For each column c from 0 → n-1:

Check if position is safe:

column c is not in cols
(row + c) not in posDiag
(row - c) not in negDiag


If unsafe → skip




5. Place queen (choose step)

Place 'Q' at (row, c)
Add:

c → cols
(row + c) → posDiag
(row - c) → negDiag




6. Recurse

Call DFS for next row → row + 1


7. Backtrack (undo choice)

Remove queen from (row, c) → set '.'
Remove c, (row + c), (row - c) from sets


8. Repeat exploration

Continue trying next column in same row
*/



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
