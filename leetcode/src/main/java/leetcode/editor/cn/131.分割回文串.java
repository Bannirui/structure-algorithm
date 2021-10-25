import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {

    // 初始化的dp表 dp[i][j] str[i...j]是否是回文
    boolean[][] dp;

    // 结果 所有回文分割方案
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        // base case
        int strLen = 0;
        if (s == null || (strLen = s.length()) == 0) {
            return this.res;
        }
        // 初始化dp
        this.dp = this.getDP(s);
        // 回溯找回文
        this.split(s, 0, new ArrayList<String>());
        // 结果
        return this.res;
    }

    // 根据字符串处理出dp数组
    private boolean[][] getDP(String s) {
        int len = s.length();
        // 默认值所有元素全是false
        boolean[][] dp = new boolean[len][len];
        // base case 要根据对角线从左下往右上推 预处理的时候把dp填充成true
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        return dp;
    }

    // 从s[start...]出发找回文
    private void split(String s, int start, List<String> path) {
        // base case
        if (start == s.length()) {
            // 收集答案
            this.res.add(new ArrayList<String>(path));
            return;
        }
        // 当前脚标start 找s中[start...i]的回文
        for (int end = start; end < s.length(); end++) {
            if (this.dp[start][end]) {
                // 找到了回文
                String subStr = s.substring(start, end + 1);
                // 复制对象 替代现场恢复
                List<String> newPath = new ArrayList<String>(path) {
                    {
                        add(subStr);
                    }
                };
                this.split(s, end + 1, newPath);
            }
        }
    }
}
// @lc code=end
