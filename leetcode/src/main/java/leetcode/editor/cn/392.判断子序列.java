/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen>tLen){
            return false;
        }
        boolean[][] dp = new boolean[sLen+1][tLen+1];
        // base case
        // 首列
        for(int i=0;i<=sLen;i++){
            dp[i][0] = false;
        }
        // 首行
        for(int i=0;i<=tLen;i++){
            dp[0][i] = true;
        }
        // 左上角->右下角
        for(int i=1;i<=sLen;i++){
            for(int j=1;j<=tLen;j++){
                dp[i][j] = (dp[i-1][j-1]&&s.charAt(i-1)==t.charAt(j-1))||dp[i][j-1];
            }
        }
        return dp[sLen][tLen];
    }
}
// @lc code=end

