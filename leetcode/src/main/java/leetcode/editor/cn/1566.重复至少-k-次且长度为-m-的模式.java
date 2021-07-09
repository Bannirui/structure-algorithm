/*
 * @Author: dingrui
 * @Date: 2021-07-09 16:56:13
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 17:31:44
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1566 lang=java
 *
 * [1566] 重复至少 K 次且长度为 M 的模式
 */

// @lc code=start
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        // 暴力
        // start右移 最后剩下的长度不足m*k就是极限
        for (int start = 0; start <= (arr.length - 1) - (m * k) + 1; start++) {
            // 至少有k组长度为m的 第一组的脚标[start, start+m-1]
            int offset = 0;
            for (; offset < m * k; offset++) {
                if (arr[start + offset] != arr[start + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
