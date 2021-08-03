/*
 * @Author: dingRui
 * @Date: 2021-08-03 16:15:19
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 16:43:52
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        // 二分
        int len = citations.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (citations[mid] >= len - mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return len - l;
    }
}
// @lc code=end
