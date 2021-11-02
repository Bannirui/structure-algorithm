/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // dp[i, j] [i...j]是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // base case 单独字符肯定是true 推算是从左下角往右上角对角线 为了计算把左下角全部初始化为true
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                if(i>=j){
                    dp[i][j] = true;
                }
            }
        }
        // 记录结果
        int maxLen=1;
        int start=0;
        int end=0;
        // 状态转移
        for(int i=s.length()-2; i>=0; i--){
            for(int j=i+1; j<s.length(); j++){
                    dp[i][j] = dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                    if(dp[i][j] && (j-i+1>maxLen)){
                        // 更新最长子串
                        maxLen = j-i+1;
                        start = i;
                        end = j;
                    }
            }
        }
        return s.substring(start, end+1);
    }
}
// @lc code=end

