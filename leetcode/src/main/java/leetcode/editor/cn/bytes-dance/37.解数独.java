/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    
    private int ROWS;
    private int COLS;

    public void solveSudoku(char[][] board) {
        if(board==null || (this.ROWS=board.length)!=9 || (this.COLS=board[0].length)!=9) throw new IllegalArgumentException();
        // mark
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boardUsed = new boolean[3][3][10];
        for(int i=0;i<this.ROWS;i++){
            for(int j=0;j<this.COLS;j++){
                char curCh=board[i][j];
                if(curCh=='.') continue;
                int curNum=curCh-'0';
                rowUsed[i][curNum]=true;
                colUsed[j][curNum]=true;
                boardUsed[i/3][j/3][curNum]=true;
            }
        }
        // dfs
        this.back(board, rowUsed, colUsed, boardUsed,0,0);
    }

    private boolean back(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boardUsed, int r, int c)
    {
        if(c==this.COLS){
            c=0;
            r++;
            if(r==this.ROWS) return true;
        }
        // 已经填好了数字
        if(board[r][c]!='.') return this.back(board,rowUsed,colUsed,boardUsed,r,c+1);
        // 待填数字 尝试
        for(int num=1;num<=9;num++){
            boolean used = rowUsed[r][num] || colUsed[c][num] || boardUsed[r/3][c/3][num];
            if(used) continue;
            // update record
            board[r][c]=(char)('0'+num);
            rowUsed[r][num]=true;
            colUsed[c][num]=true;
            boardUsed[r/3][c/3][num]=true;
            if(this.back(board,rowUsed,colUsed,boardUsed,r,c+1)) return true;
            // 现场恢复
            board[r][c]='.';
            rowUsed[r][num]=false;
            colUsed[c][num]=false;
            boardUsed[r/3][c/3][num]=false;
        }
        return false;
    }
}
// @lc code=end

