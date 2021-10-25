/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 入参校验
        int len = 0;
        if (s == null || (len = s.length()) == 0) {
            return false;
        }
        // 检索单词是否存在于集合中
        Set<String> set = new HashSet<>(wordDict);
        // dp[i] s[0...i]是否可以拆分
        boolean[] dp = new boolean[len + 1];
        // base case 空字符串
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int start = 0; start < i; start++) {
                String curStr = s.substring(start, i);
                if (dp[start] && set.contains(curStr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
// @lc code=end
