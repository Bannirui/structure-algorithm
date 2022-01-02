/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=0, len2=0;
        if(text1==null || (len1=text1.length())==0 || text2==null || (len2=text2.length())==0) return 0;
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=len2; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                int delta = text1.charAt(i-1) == text2.charAt(j-1)?1:0;
                dp[i][j] = Math.max(dp[i-1][j-1]+delta, Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

