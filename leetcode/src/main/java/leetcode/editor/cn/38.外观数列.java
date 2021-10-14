/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution
{
    public String countAndSay(int n)
    {
        // n [1...30]
        if (n <= 0)
        {
            return "";
        }
        // base case
        if (n == 1)
        {
            return "1";
        }
        String tmp = this.countAndSay(n - 1);
        StringBuffer sb = new StringBuffer();
        char curCh = tmp.charAt(0);
        int curCount = 1;
        for (int i = 1; i < tmp.length(); i++)
        {
            if (tmp.charAt(i) != curCh)
            {
                // 收集答案
                sb.append(curCount);
                sb.append(curCh);
                curCh = tmp.charAt(i);
                curCount = 1;
            }
            else
            {
                // 计数
                curCount++;
            }
        }
        sb.append(curCount);
        sb.append(curCh);
        return sb.toString();
    }
}
// @lc code=end
