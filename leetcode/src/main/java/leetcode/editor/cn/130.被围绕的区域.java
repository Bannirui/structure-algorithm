/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public void solve(char[][] board) {
        // 入口在4个边上 感染
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||i==board.length-1||j==0||j==board[0].length-1){
                    this.dfs(board,i,j);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // Z->O O->X
                if(board[i][j]=='Z'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        // base case
        if(board[i][j]!='O'){
            return;
        }
        // O->Z
        board[i][j]='Z';
        for(int[] direction: directions){
            int x=i+direction[0];
            int y=j+direction[1];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length){
                this.dfs(board,x,y);
            }
        }
    }
}
// @lc code=end

