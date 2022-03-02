/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int ROWS=0, COLS=0;
        if(matrix==null || (ROWS=matrix.length)==0 || (COLS=matrix[0].length)==0) throw new IllegalArgumentException();
        // 以[i,j]为右下角顶点的最大边长
        int[][] dp = new int[ROWS][COLS];
        int maxLen=0;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(matrix[i][j]=='0') continue;
                if(i==0||j==0) dp[i][j]=1;
                else dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                maxLen=Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen*maxLen;
    }
}
// @lc code=end

