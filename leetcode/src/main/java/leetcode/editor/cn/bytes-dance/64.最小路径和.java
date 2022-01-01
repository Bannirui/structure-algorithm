/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] dp = new int[ROW][COL];
        dp[ROW-1][COL-1]=grid[ROW-1][COL-1];
        for(int i=ROW-2;i>=0;i--){ // COL-1
            dp[i][COL-1]=dp[i+1][COL-1]+grid[i][COL-1];
        }
        for(int i=COL-2;i>=0;i--){ // ROW-1
            dp[ROW-1][i] = dp[ROW-1][i+1]+grid[ROW-1][i];
        }
        for(int i=ROW-2;i>=0;i--){
            for(int j=COL-2;j>=0;j--){
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])+grid[i][j];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

