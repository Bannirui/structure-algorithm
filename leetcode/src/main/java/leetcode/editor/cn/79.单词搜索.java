/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(this.dfs(board,i,j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int idx){
        // base case
        if(word.charAt(idx)!=board[x][y]){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        char curCh = board[x][y];
        board[x][y] = '#';
        for(int[] direction: this.directions){
            int newX = x+direction[0];
            int newY = y+direction[1];
            if(0<=newX && newX<board.length && 0<=newY && newY<board[0].length){
                if(this.dfs(board, newX, newY, word, idx+1)){
                    return true;
                }
            }
        }
        board[x][y]=curCh;
        return false;
    }
}
// @lc code=end

