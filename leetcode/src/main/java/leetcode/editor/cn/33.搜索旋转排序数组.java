/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution
{
    public int search(int[] nums, int target)
    {
        // param check
        int len = 0;
        if (nums == null || (len = nums.length) == 0)
        {
            return -1;
        }
        // base case
        if (len == 1)
        {
            return nums[0] == target ? 0 : -1;
        }
        if (target < nums[0] && target > nums[len - 1])
        {
            return -1;
        }
        // bs
        int L = 0, R = len - 1;
        while (L <= R)
        {
            int mid = L + ((R - L) >>> 1);
            if (nums[mid] == target)
            {
                return mid;
            }
            if (nums[L] <= nums[mid])
            {
                // 左边有序
                if (nums[L] <= target && target <= nums[mid])
                {
                    // target在[L...mid)
                    R = mid - 1;
                }
                else
                {
                    // target在(mid...R]
                    L = mid + 1;
                }
            }
            else
            {
                // 右边有序
                if (nums[mid] <= target && target <= nums[R])
                {
                    // target在(mid...R]
                    L = mid + 1;
                }
                else
                {
                    // target在[L...mid)
                    R = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
