/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int ROWS=grid.length;
        int COLS=grid[0].length;
        int[][] dp = new int[ROWS][COLS];
        // base case
        // final row
        dp[ROWS-1][COLS-1]=grid[ROWS-1][COLS-1];
        for(int i=COLS-2;i>=0;i--){
            dp[ROWS-1][i]=dp[ROWS-1][i+1]+grid[ROWS-1][i];
        }
        // final col
        for(int i=ROWS-2;i>=0;i--){
            dp[i][COLS-1]=dp[i+1][COLS-1]+grid[i][COLS-1];
        }
        // 右下角->左上角
        for(int i=ROWS-2;i>=0;i--){
            for(int j=COLS-2;j>=0;j--){
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

