class Solution {
     // row, column (r,c) to track the matrix and i to track the word
    // starting from (0,0) and 0 respectively
    // rowLength = board.length 
    // column length = board[0].length;
    Set<Pair<Integer, Integer>> path = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, 0, board, word)) return true;
            }
        }
        return false;
    }


 
    private boolean dfs(int r, int c, int i, char[][] board, String word) {
        if (i == word.length()) 
            return true;

        if ( r < 0 || c < 0 || r >= board.length || c >= board[0].length 
           || board[r][c] != word.charAt(i) || path.contains(new Pair<>(r, c))) 
           return false;

        path.add(new Pair<>(r, c)); // found a new character in the word
        boolean result = dfs(r + 1, c, i + 1, board, word)
                      || dfs(r - 1, c, i + 1, board, word)
                      || dfs(r, c + 1, i + 1, board, word)
                      || dfs(r, c - 1, i + 1, board, word);
        path.remove(new Pair<>(r, c)); // since you are backtracking remove the current before returning irrespective of the result (true/false)
        return result;
    }
}
