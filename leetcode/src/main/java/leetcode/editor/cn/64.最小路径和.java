/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int R=grid.length;
        int C=grid[0].length;
        int[][] dp = new int[R][C];
        // base case
        for(int i=R-1;i>=0;i--){
            for(int j=C-1;j>=0;j--){
                if(i==R-1&&j==C-1){
                    dp[i][j] = grid[i][j];
                }else{
                    // 右边和下边 比较最小值
                    int rightSum = j+1<C?dp[i][j+1]:Integer.MAX_VALUE;
                    int downSum = i+1<R?dp[i+1][j]:Integer.MAX_VALUE;
                    dp[i][j] = Math.min(rightSum, downSum)+grid[i][j];
                } 
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

