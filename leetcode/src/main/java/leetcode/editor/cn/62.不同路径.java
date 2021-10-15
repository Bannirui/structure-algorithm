/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution
{
    public int uniquePaths(int m, int n)
    {
        // dp[i][j] (i,j)->(m-1,n-1)的不同路径
        int[][] dp = new int[m][n];
        // base case
        for (int i = 0; i < m; i++)
        {
            // 最后一列
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++)
        {
            // 最后一行
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--)
        {
            for (int j = n - 2; j >= 0; j--)
            {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end
