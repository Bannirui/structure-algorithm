/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        // dp[i][j]以matrix[i, j]为右下角终点的正方形最大边长
        // [i,j]单个单元格
        // [i-1,j-1]到[i,j]也是正方形
        // 左上角往右下角推
        int len=matrix.length;
        int wid=matrix[0].length;
        int[][] dp =new int[len][wid];
        int maxLen=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<wid;j++){
                // [i,j]
                if(matrix[i][j]=='1'){
                    // base case
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    }
                    maxLen=Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
}
// @lc code=end

