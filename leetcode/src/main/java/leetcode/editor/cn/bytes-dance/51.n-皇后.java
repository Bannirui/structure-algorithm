/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // init
        for(char[] row: board) Arrays.fill(row, '.');
        List<List<String>> ret = new ArrayList<>();
        this.backtrack(board, 0, ret);
        return ret;
    }

    private void backtrack(char[][] board, int row, List<List<String>> ret){
        // base case
        if(row==board.length) {
            ret.add(this.arr2List(board));
            return;
        }
        int COLS=board[row].length;
        for(int i=0;i<COLS;i++){
            if(!isValid(board, row, i)) continue;
            board[row][i]='Q';
            this.backtrack(board,row+1, ret);
            board[row][i]='.'; // 恢复现场
        }
    }

    private boolean isValid(char[][] board, int row, int col){
        int ROWS=board.length;
        int COLS=board[0].length;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(i==row || j==col || Math.abs(i-row)==Math.abs(j-col)) if(board[i][j]=='Q') return false;
            }
        }
        return true;
    }

    private List arr2List(char[][] board){
        List<String> ret=new ArrayList<>();
        for(char[] row: board) ret.add(String.copyValueOf(row));
        return ret;
    }
}
// @lc code=end

