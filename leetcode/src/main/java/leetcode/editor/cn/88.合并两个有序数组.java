/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        // nums从后往前排序
        int idx1 = m - 1;
        int idx2 = n - 1;
        int curIdx = m + n - 1;
        int curVal;
        while (idx1 >= 0 || idx2 >= 0)
        {
            if (idx1 == -1)
            {
                // nums1已经全部排完 剩下nums2
                curVal = nums2[idx2];
                idx2--;
            }
            else if (idx2 == -1)
            {
                // nums2已经全部排完 剩下nums1
                curVal = nums1[idx1];
                idx1--;
            }
            else if (nums1[idx1] >= nums2[idx2])
            {
                // 较大值
                curVal = nums1[idx1];
                idx1--;
            }
            else
            {
                // 较大值
                curVal = nums2[idx2];
                idx2--;
            }
            nums1[curIdx] = curVal;
            curIdx--;
        }
    }
}
// @lc code=end
