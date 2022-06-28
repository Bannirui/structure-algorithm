/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null) throw new IllegalArgumentException();
        int sLen=s.length(), pLen=p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        // dp[i][j] s[0...i-1]的前i个字符与p[0...j-1]的前j个字符是否匹配
        // base case
        dp[0][0]=true;

        for(int i=0;i<=sLen;i++){
            for(int j=1;j<=pLen;j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(this.matches(s,p,i,j-1)) dp[i][j]=dp[i][j] || dp[i-1][j];
                }else
                    if(this.matches(s,p,i,j)) dp[i][j]=dp[i-1][j-1];
            }
        }
        return dp[sLen][pLen];
    }

    private boolean matches(String s, String p, int i, int j){
        if(i==0) return false;
        if(p.charAt(j-1) == '.') return true;
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
// @lc code=end

