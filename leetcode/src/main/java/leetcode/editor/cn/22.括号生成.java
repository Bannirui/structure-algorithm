/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution
{
    private List<String> res = new ArrayList<String>();
    // 括号对的数量上限
    private Integer singleMax;

    public List<String> generateParenthesis(int n)
    {
        // base case
        if (n <= 0)
        {
            return Collections.EMPTY_LIST;
        }
        // 左括号+右括号数量
        this.singleMax = n;
        // 左括号数量=0 右括号数量=0
        this.backTrace("", 0, 0);
        return this.res;
    }

    // 回溯法
    private void backTrace(String path, int left, int right)
    {
        // base case
        if (path.length() == this.singleMax * 2)
        {
            // 收集结果
            this.res.add(new String(path));
            return;
        }
        if (left < this.singleMax)
        {
            // 继续放左括号 恢复现场
            String newPath = path + "(";
            this.backTrace(newPath, left + 1, right);
        }
        else
        {
            // 不放左括号
        }

        if (right < left)
        {
            // 尝试放右括号
            String newPath = path + ")";
            this.backTrace(newPath, left, right + 1);
        }
        else
        {
            // 不放右括号
        }
    }
}
// @lc code=end
