/*
 * @Author: dingrui
 * @Date: 2021-07-06 17:00:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 17:08:14
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1317 lang=java
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int num = 1; num <= (n << 1); num++) {
            if (nonZero(num) && nonZero(n - num)) {
                return new int[] { num, n - num };
            }
        }
        return new int[2];
    }

    // num数字中各位是否包含0 不包含返回true 包含返回false
    private boolean nonZero(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 0) {
            int left = num % 10;
            if (left == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
// @lc code=end
