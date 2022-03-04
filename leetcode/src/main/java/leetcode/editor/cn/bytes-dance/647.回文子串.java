/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) throw new IllegalArgumentException();
        boolean[][] dp = new boolean[len][len];
        // base case
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i>=j) dp[i][j]=true;
            }
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
            }
        }
        int ret=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i<=j && dp[i][j]) ret++;
            }
        }
        return ret;
    }
}
// @lc code=end

