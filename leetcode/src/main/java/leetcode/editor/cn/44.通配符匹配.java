import javax.swing.text.PlainView;

/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution
{
    public boolean isMatch(String s, String p)
    {
        int sLen = s.length();
        int pLen = p.length();
        // dp[i][j]语义 s中前i个字符与p中前j个字符匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // base case
        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++)
        {
            if (p.charAt(i - 1) == '*')
            {
                // 连续的*
                dp[0][i] = true;
            }
            else
            {
                break;
            }
        }

        for (int i = 1; i <= sLen; i++)
        {
            for (int j = 1; j <= pLen; j++)
            {
                char curP = p.charAt(j - 1);
                if ('*' == curP)
                {
                    // 不使用* 或者 使用*
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                else if ('?' == curP || s.charAt(i - 1) == p.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][pLen];
    }
}
// @lc code=end
