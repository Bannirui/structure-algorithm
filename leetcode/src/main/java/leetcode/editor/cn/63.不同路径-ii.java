/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROWS = obstacleGrid.length;
        int COLS = obstacleGrid[0].length;
        int[][] dp = new int[ROWS][COLS];
        // base case
        dp[ROWS-1][COLS-1]=obstacleGrid[ROWS-1][COLS-1]==1?0:1;
        // 最后一行
        for(int i=COLS-2;i>=0;i--){
            dp[ROWS-1][i]=obstacleGrid[ROWS-1][i]==1?0:dp[ROWS-1][i+1];
        }
        // 最后一列
        for(int i=ROWS-2;i>=0;i--){
            dp[i][COLS-1]=obstacleGrid[i][COLS-1]==1?0:dp[i+1][COLS-1];
        }
        // 右下角->左上角
        for(int i=ROWS-2;i>=0;i--){
            for(int j=COLS-2;j>=0;j--){
                dp[i][j]=obstacleGrid[i][j]==1?0:(dp[i+1][j]+dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

