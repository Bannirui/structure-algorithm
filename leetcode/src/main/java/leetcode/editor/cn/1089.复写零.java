/*
 * @Author: dingrui
 * @Date: 2021-07-01 14:04:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 14:10:43
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[++i] = 0;
            }
        }
    }
}
// @lc code=end
