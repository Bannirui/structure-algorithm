/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(this.dfs(board, i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int idx){
        // base case
        if(board[r][c]!=word.charAt(idx)){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        // 已经访问过
        if(board[r][c] == '#'){
            return false;
        }
        
        // 标识当前位置已经访问过
        char remark = board[r][c];
        board[r][c]='#';
        boolean up=false, down=false, left=false, right=false;
        // 边界
        if(r-1>=0){
            up=this.dfs(board, r-1, c, word, idx+1);
        }
        if(r+1<board.length){
            down=this.dfs(board,r+1,c,word,idx+1);
        }
        if(c-1>=0){
            left=this.dfs(board,r,c-1,word,idx+1);
        }
        if(c+1<board[0].length){
            right=this.dfs(board,r,c+1,word,idx+1);
        }
        // 现场恢复
        board[r][c]= remark;
        return up||down||left||right;
        
    }
}
// @lc code=end

