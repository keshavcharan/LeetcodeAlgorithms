// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

class Solution {
    public boolean exist(char[][] board, String word) {        
        int[][] dims = new int[4][2];
        dims[0][0] = 0;
        dims[0][1] = 1;
        dims[1][0] = 1;
        dims[1][1] = 0;
        dims[2][0] = 0;
        dims[2][1] = -1;
        dims[3][0] = -1;
        dims[3][1] = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && boardHelper(board, word, i, j, dims, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean boardHelper (char[][] board, String word, int x, int y, int[][] dims, int wordindex) {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || wordindex >= word.length() || word.charAt(wordindex) == '#' || word.charAt(wordindex) != board[x][y]) {
            return false;
        }
        
        if(wordindex == word.length() -1)   return true;
        
        char tmp = board[x][y];
        board[x][y] = '#';
        boolean ret = false;
        for(int i = 0; i < 4; i++) {
            ret = boardHelper(board, word, x + dims[i][0], y + dims[i][1], dims,  wordindex+1);
            if(ret)
                break;
        }
        
        board[x][y] = tmp;
        return ret;
    }
}