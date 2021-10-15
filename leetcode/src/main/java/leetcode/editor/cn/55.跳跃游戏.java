import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution
{
    // 记忆化搜索 1=可达 0=不可达 -1=未初始化
    int[] cache;

    public boolean canJump(int[] nums)
    {
        // 记忆化搜索
        this.cache = new int[nums.length];
        Arrays.fill(this.cache, -1);
        return this.jump2End(nums, 0);
    }

    private boolean jump2End(int[] nums, int startIdx)
    {
        // 当前脚标的值代表步进值
        int step = nums[startIdx];
        // base case
        if (startIdx + step >= nums.length - 1)
        {
            return true;
        }
        for (int i = 1; i <= step; i++)
        {
            int newStartIdx = startIdx + i;
            if (this.cache[newStartIdx] == 1)
            {
                return true;
            }
            else if (this.cache[newStartIdx] == 0)
            {
                // ignore
            }
            else
            {
                boolean canArrive = this.jump2End(nums, newStartIdx);
                this.cache[newStartIdx] = canArrive ? 1 : 0;
                if (canArrive)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
