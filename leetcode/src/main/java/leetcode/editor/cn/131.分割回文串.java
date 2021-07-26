import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-26 10:20:04
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 11:08:25
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {

    private List<List<String>> res = new ArrayList<>();

    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        // dp数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        // r>=c 都为true
        for (int r = 0; r < s.length(); r++) {
            Arrays.fill(dp[r], true);
        }
        for (int r = s.length() - 1; r >= 0; r--) {
            for (int c = s.length() - 1; c >= 0; c--) {
                if (c > r) {
                    dp[r][c] = dp[r + 1][c - 1] && (s.charAt(r) == s.charAt(c));
                }
            }
        }
        this.dp = dp;
        this.dfs(s, 0, new ArrayList<>());
        return this.res;
    }

    // 从s中[i...]分割出回文字符串
    private void dfs(String s, int i, List<String> path) {
        // base case
        if (i == s.length()) {
            this.res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                // s[i...j]是回文字符串
                List<String> copyPath = new ArrayList<String>(path);
                copyPath.add(s.substring(i, j + 1));
                dfs(s, j + 1, copyPath);
            }
        }
    }
}
// @lc code=end
