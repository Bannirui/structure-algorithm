import java.nio.ReadOnlyBufferException;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution
{
    public int[] searchRange(int[] nums, int target)
    {
        // param check
        int len = 0;
        if (nums == null || (len = nums.length) == 0)
        {
            return new int[] {-1, -1};
        }
        // bs
        int targetIndex = -1;
        int l = 0, r = len - 1;
        while (l <= r)
        {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target)
            {
                targetIndex = mid;
                break;
            }
            else if (nums[mid] > target)
            {
                // [left...mid]
                r = mid - 1;
            }
            else
            {
                // [mid...right]
                l = mid + 1;
            }
        }
        if (targetIndex == -1)
        {
            return new int[] {-1, -1};
        }
        else
        {
            int firstIdx = -1, lastIdx = -1;
            // first
            for (int i = targetIndex; i >= 0; i--)
            {
                if (nums[i] == target)
                {
                    firstIdx = i;
                }
                else
                {
                    break;
                }
            }
            // last
            for (int i = targetIndex; i < len; i++)
            {
                if (nums[i] == target)
                {
                    lastIdx = i;
                }
                else
                {
                    break;
                }
            }
            return new int[] {firstIdx, lastIdx};
        }
    }
}
// @lc code=end
