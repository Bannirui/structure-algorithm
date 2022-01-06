/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int sLen =0, pLen=0;
        if(s==null || p==null) throw new RuntimeException("err");
        sLen=s.length();
        pLen=p.length();
        // [...i][...j]
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        // base case
        dp[0][0]=true;
        for(int i=1;i<=pLen;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=true;
            }else{
                break;
            }
        }
        for(int i=1;i<=sLen;i++){
            for(int j=1;j<=pLen;j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }else if(p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=(s.charAt(i-1)==p.charAt(j-1)) && dp[i-1][j-1];
                }
            }
        }
        return dp[sLen][pLen];
    }
}
// @lc code=end

