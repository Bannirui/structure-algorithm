/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        // 标识回文串数组
        int len=s.length();
        boolean[][] dp = new boolean[len][len];
        // base case
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=true;
            }
        }
        // 推导 右下角往左上角
        for(int i=len-2;i>=0;i--){
            for(int j=i+1;j<len;j++){
                dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
            }
        }
        // 计数
        int cnt=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(dp[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
// @lc code=end

