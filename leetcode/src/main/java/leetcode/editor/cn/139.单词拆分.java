/*
 * @Author: dingrui
 * @Date: 2021-07-27 16:59:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-27 17:26:33
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] dp[0...s.length()]s中前i个字符串是否可以分割成单词列表
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        // base case
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[0...j]
                String sub = s.substring(j, i);
                if (dp[j] && set.contains(sub)) {
                    // 存在一种形式 s[0...j]可以拆分成单词列表 并且 s[j...i]这个单词也在单词列表中
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end
