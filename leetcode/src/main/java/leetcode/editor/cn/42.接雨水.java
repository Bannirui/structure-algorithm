import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution
{
    public int trap(int[] height)
    {
        int res = 0;
        // 单调栈 递减 遇到递增的就开始计算雨量
        Stack<Integer> descStack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++)
        {
            int curHeight = height[i];
            while (!descStack.isEmpty() && curHeight > height[descStack.peek()])
            {
                int midIdx = descStack.pop();
                if (!descStack.isEmpty())
                {
                    int leftIdx = descStack.peek();
                    int h = Math.min(curHeight, height[leftIdx]) - height[midIdx];
                    int w = i - leftIdx - 1;
                    res += (h * w);
                }
            }
            descStack.push(i);
        }
        return res;
    }
}
// @lc code=end
