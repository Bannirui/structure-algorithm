/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution
{
    public void sortColors(int[] nums)
    {
        // 0 1 2 荷兰国旗
        int preIdx = 0, postIdx = nums.length - 1;
        for (int i = 0; i <= postIdx; i++)
        {
            while (i <= postIdx && nums[i] == 2)
            {
                // 扩张postIdx
                int tmp = nums[postIdx];
                nums[postIdx] = nums[i];
                nums[i] = tmp;
                postIdx--;
            }
            if (nums[i] == 0)
            {
                // 扩张preIdx
                int tmp = nums[preIdx];
                nums[preIdx] = nums[i];
                nums[i] = tmp;
                preIdx++;
            }
        }
    }
}
// @lc code=end
