/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=0, cols=0;
        if(obstacleGrid==null || (rows=obstacleGrid.length)==0 || (cols=obstacleGrid[0].length)==0) throw new IllegalArgumentException();
        if(obstacleGrid[rows-1][cols-1]==1) return 0;
        int[][] dp = new int[rows][cols];
        for(int i=rows-1;i>=0;i--){
            if(obstacleGrid[i][cols-1]==1){
                dp[i][cols-1]=0;
                break;
            }else dp[i][cols-1]=1;
        }
        for(int j=cols-1;j>=0;j--){
             if(obstacleGrid[rows-1][j]==1){
                dp[rows-1][j]=0;
                break;
             }else dp[rows-1][j]=1;
        }
        for(int i=rows-2;i>=0;i--){
            for(int j=cols-2;j>=0;j--){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j]=dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

