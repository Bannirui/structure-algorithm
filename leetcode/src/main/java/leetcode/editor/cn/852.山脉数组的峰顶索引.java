/*
 * @Author: dingrui
 * @Date: 2021-06-28 16:52:19
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 17:03:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // 二分
        int l = 0, r = arr.length - 2;
        int res = -1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            // 数组边界
            if (arr[mid] > arr[mid + 1]) {
                // 左边可能还存在一个更大的 缓存结果
                res = mid;
                r = mid - 1;
            } else {
                // 没找到 继续右边查找
                l = mid + 1;
            }
        }
        return res;
    }
}
// @lc code=end
