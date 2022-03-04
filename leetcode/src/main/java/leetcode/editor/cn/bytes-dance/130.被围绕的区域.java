/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int ROWS=0;
        int COLS=0;
        if(board==null || (ROWS=board.length)==0 || (COLS=board[0].length)==0) throw new IllegalArgumentException();
        if(ROWS==1 || COLS==1) return;
        // O->Z
        for(int i=0;i<ROWS;i++){
            if(board[i][0]=='O') this.dfs(board, i, 0, 'Z');
            if(board[i][COLS-1]=='O') this.dfs(board,i,COLS-1,'Z');
        }
        for(int i=0;i<COLS;i++){
            if(board[0][i]=='O') this.dfs(board,0,i,'Z');
            if(board[ROWS-1][i]=='O') this.dfs(board,ROWS-1,i,'Z');
        }
        // O->X
        for(int i=1;i<ROWS-1;i++){
            for(int j=1;j<COLS-1;j++){
                if(board[i][j]=='O') this.dfs(board,i,j,'X');
            }
        }
        // Z->O
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(board[i][j]=='Z') board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, char dest){
        // base case
        if(board[i][j]!='O') return;
        board[i][j]=dest;
        for(int[] direction: directions){
            int deltaX=direction[0];
            int deltaY=direction[1];
            int newX=i+deltaX;
            int newY=j+deltaY;
            if(newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length){
                this.dfs(board,newX,newY,dest);
            }
        }
    }
}
// @lc code=end

