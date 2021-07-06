/*
 * @Author: dingrui
 * @Date: 2021-07-06 22:53:08
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 22:56:16
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1346 lang=java
 *
 * [1346] 检查整数及其两倍数是否存在
 */

// @lc code=start
class Solution {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
