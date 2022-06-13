/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int ROWS=0, COLS=0;
        if(matrix==null||(ROWS=matrix.length)==0||(COLS=matrix[0].length)==0 || ROWS!=COLS) throw new IllegalArgumentException();
        int[][] dp = new int[ROWS+1][COLS+2];
        // init
        for(int i=0;i<COLS+2;i++) dp[0][i]=0;
        for(int i=1;i<ROWS+1;i++){
            dp[i][0]=Integer.MAX_VALUE;
            dp[i][COLS+2-1]=Integer.MAX_VALUE;
        }

        for(int i=1;i<ROWS+1;i++){
            for(int j=1;j<COLS+2-1;j++){
                dp[i][j]=matrix[i-1][j-1]+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i-1][j+1]));
            }
        }
        int ret=Integer.MAX_VALUE;
        for(int i=1;i<COLS+2-1;i++) ret = Math.min(ret, dp[ROWS+1-1][i]);
        return ret;
    }
}
// @lc code=end

