/*
 * @Author: dingrui
 * @Date: 2021-07-08 13:37:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 13:42:29
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1460 lang=java
 *
 * [1460] 通过翻转子数组使两个数组相等
 */

// @lc code=start
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // base case
        if (target.length != arr.length) {
            return false;
        }
        int[] targetCount = new int[1001];
        int[] arrCount = new int[1001];
        for (int targetNum : target) {
            targetCount[targetNum]++;
        }
        for (int arrNum : arr) {
            arrCount[arrNum]++;
        }
        // 计数比较
        for (int i = 0; i <= 1000; i++) {
            if (targetCount[i] != arrCount[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
