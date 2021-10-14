/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution
{
    public int firstMissingPositive(int[] nums)
    {
        // 尽可能还原数字位置
        for (int i = 0; i < nums.length; i++)
        {
            while (1 <= nums[i] && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i])
            {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        // 脚标跟值不对应的就是缺失的数字
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] - 1 != i)
            {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
// @lc code=end
