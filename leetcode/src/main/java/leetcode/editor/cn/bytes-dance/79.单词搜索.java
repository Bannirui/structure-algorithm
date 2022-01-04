/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = 0, COLS=0;
        if(board==null || (ROWS=board.length)==0 || (COLS=board[0].length)==0) return false;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                boolean ret = this.dfs(board, i, j, word, 0);
                if(ret){
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    private boolean dfs(char[][] board, int r, int c, String word, int idx){
        if(idx==word.length()) return true;
        if(r<0 || r>=board.length || c<0 || c>=board[0].length){
            return false;
        }
        // change the filled char
        char preCh = board[r][c];
        if(preCh!=word.charAt(idx)) return false;
        board[r][c] = '#';
        boolean ret = false; // record true if the word can match
        for(int[] direction: directions){
            int newR = r+direction[0];
            int newC = c+direction[1];
            if(this.dfs(board, newR, newC, word, idx+1)){
                ret = true;
                break;
            }
        }
        board[r][c]=preCh;
        return ret;
    }
}
// @lc code=end

