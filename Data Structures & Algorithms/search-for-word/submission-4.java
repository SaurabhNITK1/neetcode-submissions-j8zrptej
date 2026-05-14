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
