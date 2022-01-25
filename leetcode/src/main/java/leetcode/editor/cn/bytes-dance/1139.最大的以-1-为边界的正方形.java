/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int ROWS=0, COLS=0;
        if(grid==null||(ROWS=grid.length)==0||(COLS=grid[0].length)==0) throw new IllegalArgumentException();
        int[][][] dp = new int[ROWS+1][COLS+1][2]; // 以(i,j)为右下角 0-横向连续1个数 1-纵向连续1个数
        for(int i=1;i<=ROWS;i++){
            for(int j=1;j<=COLS;j++){
                if(grid[i-1][j-1]==0) continue;
                dp[i][j][0]=dp[i][j-1][0]+1;
                dp[i][j][1]=dp[i-1][j][1]+1;
            }
        }
        int maxLen=0;
        for(int i=1;i<=ROWS;i++){
            for(int j=1;j<=COLS;j++){
                int curLen=Math.min(dp[i][j][0],dp[i][j][1]);
                if(curLen<=maxLen) continue;
                for(;curLen>maxLen;curLen--){
                    if(dp[i][j-curLen+1][1]>=curLen && dp[i-curLen+1][j][0]>=curLen){
                        maxLen=curLen;
                        break;
                    }
                }
            }
        }
        return maxLen*maxLen;
    }
}
// @lc code=end

