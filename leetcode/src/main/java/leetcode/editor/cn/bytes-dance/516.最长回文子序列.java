/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) throw new IllegalArgumentException();
        int[][] dp=new int[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1]+2;
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }
}
// @lc code=end

