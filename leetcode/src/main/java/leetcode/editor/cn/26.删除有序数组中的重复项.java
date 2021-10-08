/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution
{
    public int removeDuplicates(int[] nums)
    {
        // base case
        int len = 0;
        if (nums == null || (len = nums.length) == 0)
        {
            return 0;
        }
        // 原数组已升序 双指针
        int slow = 0;
        int fast = 1;
        while (fast < len)
        {
            if (nums[fast - 1] != nums[fast])
            {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
            else
            {
                fast++;
            }
        }
        return slow + 1;
    }
}
// @lc code=end
