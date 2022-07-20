/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows=0;
        if(triangle==null || (rows=triangle.size())==0) throw new IllegalArgumentException();
        int[][] dp = new int[rows][rows];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<rows;i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j=1;j<i;j++){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            } 
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<rows;i++) ret=Math.min(ret, dp[rows-1][i]);
        return ret;
    }
}
// @lc code=end