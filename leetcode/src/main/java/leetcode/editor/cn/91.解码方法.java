/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution
{
    int cnt = 0;

    public int numDecodings(String s)
    {
        // 暴力递归
        // return this.dfs(s, 0, 0);
        // dp
        // base case 前导0
        if (s == null || s.charAt(0) == '0')
        {
            return 0;
        }
        return this.dp(s);
    }

    private int dp(String s)
    {
        // dp语意 dp[0...i]的解码方案
        int[] dp = new int[s.length()];
        // base case
        dp[0] = 1;
        if (s.length() >= 2)
        {
            if (s.charAt(1) != '0')
            {
                dp[1] += dp[0];
            }
            if (((s.charAt(0) - '0') * 10 + ((s.charAt(1) - '0'))) <= 26)
            {
                dp[1] += 1;
            }
        }

        for (int i = 2; i < s.length(); i++)
        {
            if (s.charAt(i) != '0')
            {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0 && s.charAt(i - 1) != '0' && ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0')) <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }

    // s中[0...idx-1]已经映射完成 从idx开始映射
    private int dfs(String s, int idx, int cnt)
    {
        // base case
        if (idx == s.length())
        {
            // 收集到一种方案
            return cnt + 1;
        }
        // 考察idx和idx+1
        if (s.charAt(idx) == '0')
        {
            return cnt;
        }
        else
        {
            // 当前一个数字+组合两个数字
            char curCh = s.charAt(idx);
            int count = this.dfs(s, idx + 1, cnt);
            if (idx + 1 < s.length())
            {
                char nextCh = s.charAt(idx + 1);
                int sum = (curCh - '0') * 10 + (nextCh - '0');
                if (sum <= 26)
                {
                    count = this.dfs(s, idx + 2, count);
                }
            }
            return count;
        }
    }
}
// @lc code=end
