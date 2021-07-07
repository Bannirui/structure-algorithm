/*
 * @Author: dingrui
 * @Date: 2021-07-07 14:28:49
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 15:08:41
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1385 lang=java
 *
 * [1385] 两个数组间的距离值
 */

// @lc code=start
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        flag: for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    // 不满足
                    continue flag;
                }
            }
            res++;
        }
        return res;
    }
}
// @lc code=end
