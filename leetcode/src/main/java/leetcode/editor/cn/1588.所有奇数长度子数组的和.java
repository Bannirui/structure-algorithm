/*
 * @Author: dingrui
 * @Date: 2021-07-10 09:38:12
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 09:47:08
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1588 lang=java
 *
 * [1588] 所有奇数长度子数组的和
 */

// @lc code=start
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // 奇数长度
        int res = 0;
        for (int len = 1; len <= arr.length; len++) {
            if (len % 2 != 0) {
                // 窗口大小=len
                int windowSum = 0;
                // 窗口初始化
                for (int i = 0; i < len; i++) {
                    windowSum += arr[i];
                }
                res += windowSum;
                // 窗口移动
                for (int j = len; j < arr.length; j++) {
                    windowSum += arr[j];
                    windowSum -= arr[j - len];
                    res += windowSum;
                }
            }
        }
        return res;
    }
}
// @lc code=end
