/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 可以被一步捕获的棋子数
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        int ROWS=0, COLS=0;
        if(board==null || (ROWS=board.length)==0 || (COLS=board[0].length)==0) throw new IllegalArgumentException();
        int[] pos = this.findStartPos(board);
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int ret=0;
        for(int[] dirction: directions){
            for(int step=0;;step++){
                int nextX = pos[0]+dirction[0]*step;
                int nextY = pos[1]+dirction[1]*step;
                if(nextX<0 || nextX>=ROWS || nextY<0 || nextY>=COLS) break;
                char nextCh = board[nextX][nextY];
                if(nextCh=='B') break;
                if(nextCh=='p') {
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }

    // int[]{x, y}
    private int[] findStartPos(char[][] board){
        int ROWS=0, COLS=0;
        if(board==null || (ROWS=board.length)==0 || (COLS=board[0].length)==0) throw new IllegalArgumentException();
        boolean find=false;
        int[] ret = new int[2];
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(board[i][j]=='R'){
                    find=true;
                    ret[0]=i;
                    ret[1]=j;
                    break;
                }
            }
        }
        if(!find) throw new IllegalArgumentException();
        return ret;
    }
}
// @lc code=end

