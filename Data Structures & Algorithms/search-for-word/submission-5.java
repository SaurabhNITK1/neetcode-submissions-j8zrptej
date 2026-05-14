/*

✅ Algorithm: Word Search using DFS + Backtracking


Initialize traversal

Iterate through every cell (r, c) in the board.
Treat each cell as a potential starting point.



Start DFS from each cell

For each (r, c), call dfs(board, word, r, c, 0, pathSet).
If any call returns true, return true.



DFS Base Case

If i == word.length(), it means all characters are matched → return true.



Boundary & Validity Checks

If:

r or c is out of bounds, OR
board[r][c] != word.charAt(i), OR
current cell (r, c) already exists in path


→ return false.



Mark current cell as visited

Add (r, c) to the path set.



Explore 4 directions (Backtracking step)

Recursively search:

Down → (r + 1, c)
Up → (r - 1, c)
Right → (r, c + 1)
Left → (r, c - 1)


Increment index i + 1 for next character.



Combine results

If any of the recursive calls returns true, propagate true.



Backtrack (undo the choice)

Remove (r, c) from path before returning.
This allows reuse of the cell in different paths.



Return result

Return whether the word can be formed starting from this cell.



Final result



If no starting point returns true, return false.


✨ Short Javadoc-friendly version
If you want a compact one:
1. Iterate over each cell as a starting point.
2. Start DFS matching characters of the word.
3. If all characters matched → return true.
4. If out of bounds / mismatch / already visited → return false.
5. Mark cell as visited.
6. Explore 4 directions (up, down, left, right).
7. Backtrack by unmarking the cell.
8. If any path matches → return true.
9. If no path works → return false.


*/



class Solution {
     // row, column (r,c) to track the matrix and i to track the word
    // starting from (0,0) and 0 respectively
    // rowLength = board.length 
    // column length = board[0].length;
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, r, c, 0, new HashSet<>())) return true;
            }
        }
        return false;
    }


 
    private boolean dfs(char[][] board, String word, int r, int c, int i, Set<Pair<Integer, Integer>> path) {
        if (i == word.length()) 
            return true;

        if ( r < 0 || c < 0 || r >= board.length || c >= board[0].length 
           || board[r][c] != word.charAt(i) || path.contains(new Pair<>(r, c))) 
           return false;

        path.add(new Pair<>(r, c)); // found a new character in the word
        boolean result = dfs(board, word, r + 1, c, i + 1, path)
                      || dfs(board, word, r - 1, c, i + 1, path)
                      || dfs(board, word, r, c + 1, i + 1, path)
                      || dfs(board, word, r, c - 1, i + 1, path);
        path.remove(new Pair<>(r, c)); // since you are backtracking remove the current before returning irrespective of the result (true/false)
        return result;
    }
}
