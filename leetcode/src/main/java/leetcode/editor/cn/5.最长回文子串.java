/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // base case
        int len = 0;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }
        if (len == 1) {
            return s;
        }
        if (len == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        }
        // 此刻s字符串的长度>=3
        // dp[s][e]语义: s[s...e]是回文串
        boolean[][] dp = new boolean[len][len];
        // 单独字符一定是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 最长回文子串长度
        int maxLen = 0;
        int START = 0, END = 0;
        for (int end = 1; end < len; end++) {
            for (int start = 0; start < end; start++) {
                if (start + 1 <= end - 1) {
                    if (dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = true;
                    }
                } else {
                    // 连续2个字符
                    dp[start][end] = s.charAt(start) == s.charAt(end);
                }
                if (dp[start][end] && (end - start) > maxLen) {
                    maxLen = end - start;
                    START = start;
                    END = end;
                }
            }
        }
        return s.substring(START, END + 1);
    }
}
// @lc code=end
