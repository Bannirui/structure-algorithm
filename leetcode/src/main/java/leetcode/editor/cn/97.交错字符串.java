/*
 * @Author: dingrui
 * @Date: 2021-07-22 18:07:59
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-23 10:59:22
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // dp[i][j] s1贡献i个字符 s2贡献j个字符 对应s3中i+j个字符 是否交错形成
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // base case 大家都不贡献字符 一定成立
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // 现在考量i+j个字符串情况
                // s1已经贡献i个 s2已经贡献j-1个 s3中已经形成i+j-1个
                // s1已经贡献i-1个 s2已经贡献j个 s3中已经形成i+j-1个
                // s3中当前要考察的字符脚标
                int index3 = i + j - 1;
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(index3)));
                }
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(index3)));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
// @lc code=end
